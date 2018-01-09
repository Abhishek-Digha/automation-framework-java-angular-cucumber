package com.simonk.gui.configurations.springconfig;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.sergueik.jprotractor.NgWebDriver;
import com.simonk.gui.configurations.CucumberWorld;
import com.simonk.gui.configurations.FrameworkProperties;
import com.simonk.gui.configurations.webdriver.Driver;
import com.simonk.gui.pageobjects.AngularCalculatorPage;
import com.simonk.gui.utility.exceptions.InvalidDriverTypeSelectedException;
import com.simonk.gui.utility.localisation.LocaleHelper;
import com.simonk.gui.utility.reporting.ReportEnvironmentHelper;


@Configuration
@PropertySource(value = {"classpath:/framework.properties"})
public class SpringConfig {
	private static final Logger LOG = LogManager.getLogger(SpringConfig.class);


	@Bean
	public CucumberWorld cucumberWorld() {
		return new CucumberWorld();
	}
	
	@Bean(destroyMethod = "quit")
	@Scope("singleton")
	public Driver driver() {
		Driver wd = null;
		try {
		wd = new Driver(properties());
		} catch(InvalidDriverTypeSelectedException ex) {
			LOG.debug("Invalid driver specified" + ex);
			System.exit(1);
		}
		return wd;
	}
	
	@Bean
	@Scope("singleton")
	public NgWebDriver ngDriver() {
		NgWebDriver ng = new NgWebDriver(driver());
		return ng;
	}

	@Bean
	public FrameworkProperties properties() {
		return new FrameworkProperties();
	}
	

	
	@Bean
	@Scope("singleton")
	public LocaleHelper localeHelper() {
		return new LocaleHelper(properties().getApplicationLanguage());
	}
	
	@Bean
	public AngularCalculatorPage angularLoginPage() {
		 return new AngularCalculatorPage(
				 	ngDriver(),               
	                properties().seleniumImplicitWaitTime(),
	                properties().getTestServerBaseAddress()
	        );
	}

	
	@Bean
	public ReportEnvironmentHelper envHelper() throws Exception {
		HashMap<String, String> props = new HashMap<String, String>();
		props.put("Language:", properties().getApplicationLanguage());
		props.put("Browser:", properties().getBrowserType());
		props.put("Platform:", properties().getPlatformType());
		props.put("Environment:", properties().getTestServerBaseAddress());
		props.put("Architecture:", properties().getGridOrLocal());
		props.put("Grid Address:", properties().getGridAddress());
		props.put("Selenium Wait:", String.valueOf(properties().seleniumImplicitWaitTime()));
		props.put("Product Name:", String.valueOf(properties().getProductName()));
		props.put("Database Conn:", String.valueOf(properties().getDatabaseConn()));
		props.put("Angular Frontend:", String.valueOf(properties().getAngular()));			
		return new ReportEnvironmentHelper(props);
	}

	
	
}
