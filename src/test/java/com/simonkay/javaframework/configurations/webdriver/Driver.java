package com.simonkay.javaframework.configurations.webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.simonkay.javaframework.configurations.FrameworkProperties;
import com.simonkay.javaframework.utility.exceptions.FrameworkPropertiesException;
import com.simonkay.javaframework.utility.exceptions.InvalidDriverTypeSelectedException;

public class Driver extends EventFiringWebDriver {
	private static final Logger LOG = LogManager.getLogger(EventFiringWebDriver.class);

	private static WebDriver CURRENT_DRIVER;

	private static final Thread SHUTDOWN_HOOK = new Thread() {
		@Override
		public void run() {
			LOG.debug("Running browser shutdown hook");
			killDriver();
		}
	};

	@Override
	public void close() {
		if (Thread.currentThread() != SHUTDOWN_HOOK) {
			throw new UnsupportedOperationException(
					"Driver will close when the JVM exits, do not manually call .close() on it");
		}
		try {
			super.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void killDriver() {
		WebDriver driver = CURRENT_DRIVER;
		CURRENT_DRIVER = null;
		if (driver != null) {
			driver.quit();
			LOG.debug("Browser killed successfully");
		}
	}

	public Driver(FrameworkProperties props) throws InvalidDriverTypeSelectedException {
		super(getCurrentDriver(props));
		LOG.debug("Registering shutdown hook on browser: " + props.getBrowserType());
		Runtime.getRuntime().addShutdownHook(SHUTDOWN_HOOK);
	}

	private static DesiredCapabilities prepCapabilities(FrameworkProperties props) throws FrameworkPropertiesException {
		Platform platform = null;
		
		if (props.getPlatformType().toLowerCase().equals("linux")) {
			platform = Platform.LINUX;
		} else {
			platform = Platform.WINDOWS;
		} 
		
		DesiredCapabilities caps = null;
		switch (props.getBrowserType().toLowerCase()) {
		case "chrome":
			 ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.addArguments("--start-maximized");
			 caps = DesiredCapabilities.chrome();
			 caps.setBrowserName("chrome");
			 caps.setPlatform(platform);
			 caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			 return caps;
		
		case "firefox":
			 caps = DesiredCapabilities.firefox();
			 caps.setBrowserName("firefox");
			 caps.setPlatform(platform);
			 return caps;
		
		default: 
			throw new FrameworkPropertiesException("Invalid properties for browser / platform set");
		}
		
	}
	
	private static WebDriver getCurrentDriver(FrameworkProperties props) throws InvalidDriverTypeSelectedException {
		
		if (props.getGridOrLocal().toLowerCase().equals("grid")) {
			try {
				return new RemoteWebDriver(new URL(props.getGridAddress().toString()), prepCapabilities(props));
			} catch (MalformedURLException | FrameworkPropertiesException ex) {
				LOG.fatal("Invalid browsertype or platform, Exiting the test run", ex);
				System.exit(0);
			}				
		}
			
			switch (props.getBrowserType().toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"src/test/resources/binaries/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				LOG.debug("Chrome successfully set, returning new chromedriver with options: "
						+ chromeOptions);
				return new ChromeDriver(chromeOptions);
			case "firefox":
				FirefoxOptions ffOptions = new FirefoxOptions();
				System.setProperty("webdriver.firefox.driver",
						"src/test/resources/binaries/geckodriver.exe");
				LOG.debug("Firefox successfully set, returning new geckodriver with options: "
						+ ffOptions);
				return new FirefoxDriver(ffOptions);
			default:
				throw new InvalidDriverTypeSelectedException(
						"Invalid driver specified, enter: 'chrome' or 'firefox' in the "
								+ "resources/framework.properties file, this can be passed at runtime using mvn -D arguments");
			}		

		}	

}
