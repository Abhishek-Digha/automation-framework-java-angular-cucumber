package com.simonkay.javaframework.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.github.sergueik.jprotractor.NgWebDriver;
import com.simonkay.javaframework.jpagefactory.How;
import com.simonkay.javaframework.jpagefactory.annotations.FindBy;

public class AngularCalculatorPage extends AbstractBasePageObject<AngularCalculatorPage> {
	private static final Logger LOG = LogManager.getLogger(AngularCalculatorPage.class);
	
	
	@Override
	protected void load() {		
		LOG.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
		navigate_and_wait();
	}

	@Override
	protected void isLoaded() throws Error {
		 String url = getDriver().getCurrentUrl();
		 Assert.assertTrue("Not on the calculator page: " + url, url.endsWith("calc/")); 
		 LOG.warn(getClass().getSimpleName() + " was loaded successfully");
	}

	@FindBy(how = How.MODEL, using = "first")
	private WebElement first_value_box;

	@FindBy(how = How.MODEL, using = "second")
	private WebElement second_value_box;

	@FindBy(how = How.MODEL, using = "operator")
	private WebElement operator_dropbox_box;

	@FindBy(how = How.BINDING, using = "latest")
	private WebElement result_box;

	@FindBy(how = How.ID, using = "gobutton")
	private WebElement go_button;
	
	private final String relativeUrl = "calc/";

	public AngularCalculatorPage(NgWebDriver ngdriver, int implicitWait, String url) {
		super(ngdriver, implicitWait, url);
		setRelativeUrl(relativeUrl);
		LOG.debug("Instantiating page objects for " + getClass().getName());
	}

	public void multipy(int num1, int num2) throws InterruptedException {
		LOG.info("Attempting to multiply: " + num1 + " and: " + num2);
		reset_form_data();
		first_value_box.sendKeys(String.valueOf(num1));
		second_value_box.sendKeys(String.valueOf(num2));
		select_dropdown_by_value(operator_dropbox_box, "*");
		Thread.sleep(25000);
		go_button.click();
		getDriver().waitForAngular();
	}

	public void add(int num1, int num2) throws InterruptedException {
		LOG.info("Attempting to add: " + num1 + " and: " + num2);
		reset_form_data();
		set_text(first_value_box, String.valueOf(num1));
		set_text(second_value_box, String.valueOf(num2));
		select_dropdown_by_value(operator_dropbox_box, "+");
		Thread.sleep(25000);
		go_button.click();
		getDriver().waitForAngular();
	}

	public void subtract(int num1, int num2) throws InterruptedException {
		LOG.info("Attempting to subtract: " + num1 + " from: " + num2);
		reset_form_data();
		first_value_box.sendKeys(String.valueOf(num2));
		second_value_box.sendKeys(String.valueOf(num1));
		select_dropdown_by_value(operator_dropbox_box, "-");
		Thread.sleep(25000);
		go_button.click();
		getDriver().waitForAngular();
	}

	public int get_result() {		
		int result = Integer.valueOf(result_box.getText());
		LOG.info("Result was: " + result);
		return result;
	}
	
	private void reset_form_data() {
		first_value_box.clear();
		second_value_box.clear();
	}


}
