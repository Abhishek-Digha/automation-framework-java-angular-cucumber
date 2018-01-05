package com.simonkay.javaframework.pageobjects;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.sergueik.jprotractor.NgWebDriver;
import com.simonkay.javaframework.configurations.webdriver.WaitConditions;
import com.simonkay.javaframework.utility.localisation.LocaleHelper;

public abstract class AbstractBasePageObject {
	
	@Autowired
	protected LocaleHelper localeHelper;
	
	private static final Logger LOG = LogManager.getLogger(AbstractBasePageObject.class);
	protected final NgWebDriver ngDriver;
	private final int timeToWait;
	private final WebDriverWait wait;
	private final String url;
	
	protected String getUrl() {
		return this.url;
	}
	

	public AbstractBasePageObject(NgWebDriver ngdriver, int implicitWait, String url) {
		ngDriver = ngdriver;
		timeToWait = implicitWait;
		wait = new WebDriverWait(getDriver(), timeToWait);
		this.url = url;
	}

	public WebDriver getDriver() {
		return ngDriver;
	}

	public boolean does_element_exist(By loc) {
		return ngDriver.findElements(loc).size() != 0 ? true : false;
	}

	public void navigate_and_wait() {
		ngDriver.get(url);
		wait.until(ExpectedConditions.urlToBe(url));
		
	}

	public void set_text(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}

	public void submit(WebElement ele) {
		ele.submit();
	}

	public void selectDropDownByValue(WebElement ele, String valueToChoose) {
		Select s = new Select(ele);
		wait_for_dropdown(ele);
		s.selectByVisibleText(valueToChoose);
	}

	public boolean is_text_present(String text) {
		LOG.debug("Attempting to find text on the page: " + text);
		try {
			wait_until_true_or_timeout(WaitConditions.pageContainsText(text));
		} catch (TimeoutException te) {
			LOG.fatal(te.getMessage() + "\n\nPageSource:\n\n" + getDriver().getPageSource());
			return false;
		}
		return true;
	}

	private void wait_for_dropdown(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	protected WebElement find(By loc) {
		try {
			return getDriver().findElement(loc);
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(ex.getMessage()
					+ "\n\nPageSource:\n\n" + getDriver().getPageSource());
		}
	}
	
	
    /**
     * wait until condition is true or timeout is reached
     * @throws TimeoutException 
     */
    protected <V> V wait_until_true_or_timeout(ExpectedCondition<V> isTrue) throws TimeoutException {
        Wait<WebDriver> wait = new WebDriverWait(this.ngDriver, timeToWait)
                .ignoring(StaleElementReferenceException.class);
            return wait.until(isTrue);
    }

}
