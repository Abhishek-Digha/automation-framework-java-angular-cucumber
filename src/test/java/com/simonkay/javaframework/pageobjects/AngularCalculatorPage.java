package com.simonkay.javaframework.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.github.sergueik.jprotractor.NgWebDriver;
import com.simonkay.javaframework.jpagefactory.How;
import com.simonkay.javaframework.jpagefactory.JPageFactory;
import com.simonkay.javaframework.jpagefactory.annotations.FindBy;
import static org.assertj.core.api.Assertions.*;

public class AngularCalculatorPage extends AbstractBasePageObject {
	private static final Logger LOG = LogManager.getLogger(AngularCalculatorPage.class);

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

	public AngularCalculatorPage(NgWebDriver ngdriver, int implicitWait, String url) {
		super(ngdriver, implicitWait, url);
		JPageFactory.initWebElements(ngdriver, this);
		LOG.debug("Instantiating page objects for " + getClass().getName());
	}

	public void multipy(int num1, int num2) {
		LOG.info("Attempting to multiply: " + num1 + " and: " + num2);
		first_value_box.clear();
		second_value_box.clear();
		first_value_box.sendKeys(String.valueOf(num1));
		second_value_box.sendKeys(String.valueOf(num2));
		selectDropDownByValue(operator_dropbox_box, "*");
		go_button.click();
		ngDriver.waitForAngular();
	}

	public void add(int num1, int num2) {
		LOG.info("Attempting to add: " + num1 + " and: " + num2);
		first_value_box.clear();
		second_value_box.clear();
		first_value_box.sendKeys(String.valueOf(num1));
		second_value_box.sendKeys(String.valueOf(num2));
		selectDropDownByValue(operator_dropbox_box, "+");
		go_button.click();
		ngDriver.waitForAngular();
	}

	public void subtract(int num1, int num2) {
		LOG.info("Attempting to subtract: " + num1 + " from: " + num2);
		first_value_box.clear();
		second_value_box.clear();
		first_value_box.sendKeys(String.valueOf(num2));
		second_value_box.sendKeys(String.valueOf(num1));
		selectDropDownByValue(operator_dropbox_box, "-");
		go_button.click();
		ngDriver.waitForAngular();
	}

	public int get_result() {		
		return Integer.valueOf(result_box.getText());
	}

}
