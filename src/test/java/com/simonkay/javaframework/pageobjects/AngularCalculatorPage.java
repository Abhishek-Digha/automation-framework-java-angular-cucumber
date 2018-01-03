package com.simonkay.javaframework.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.simonkay.javaframework.configurations.webdriver.Driver;
import com.simonkay.javaframework.datamodels.User;

public class AngularCalculatorPage extends AbstractBasePageObject {
	private static final Logger LOG = LogManager
			.getLogger(AngularCalculatorPage.class);

	private WebElement first_value_box() {
		return driver.findElement(ByAngular.model("first"));
	}

	private WebElement second_value_box() {
		return driver.findElement(ByAngular.model("second"));
	}

	private WebElement operator_dropbox_box() {
		return driver.findElement(ByAngular.model("operator"));
	}

	private WebElement result_box() {
		return driver.findElement(ByAngular.binding("latest"));
	}

	private WebElement go_button() {
		return driver.findElement(By.id("gobutton"));
	}

	public AngularCalculatorPage(NgWebDriver ngdriver, Driver driver,
			int implicitWait, String url) {
		super(ngdriver, driver, implicitWait, url);		
	}

	public void multipy(int num1, int num2) {
		first_value_box().clear();
		second_value_box().clear();
		first_value_box().sendKeys(String.valueOf(num1));
		second_value_box().sendKeys(String.valueOf(num2));
		selectDropDownByValue(operator_dropbox_box(), "*");
		go_button().click();
		wait_for_angular();
	}
	
	public void add(int num1, int num2) {
		first_value_box().clear();
		second_value_box().clear();
		first_value_box().sendKeys(String.valueOf(num1));
		second_value_box().sendKeys(String.valueOf(num2));
		selectDropDownByValue(operator_dropbox_box(), "+");
		go_button().click();
		wait_for_angular();
	}
	
	public void subtract(int num1, int num2) {
		first_value_box().clear();
		second_value_box().clear();
		first_value_box().sendKeys(String.valueOf(num2));
		second_value_box().sendKeys(String.valueOf(num1));
		selectDropDownByValue(operator_dropbox_box(), "-");
		go_button().click();
		wait_for_angular();
	}

	public int get_result() {
		return Integer.valueOf(result_box().getText());
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {

	}

}
