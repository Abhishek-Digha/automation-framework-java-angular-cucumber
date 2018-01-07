package com.simonkay.javaframework.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.pageobjects.AngularCalculatorPage;
import com.simonkay.javaframework.utility.localisation.LocaleHelper;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AngularSteps extends AbstractBaseStepDefinition {
	private static final Logger LOG = LogManager.getLogger(AngularSteps.class);


	@Autowired
	private LocaleHelper localeHelper;
	
	@Autowired
	private AngularCalculatorPage angularCalculatorPage;
	
	
	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}
	
	@Given("^I am on the calculator page$")
	public void i_am_on_the_calculator_page() throws Throwable {
		angularCalculatorPage.get();		
	}
	
	@When("^I multiply (\\d+) times (\\d+)$")
	public void i_multiply_times(int num1, int num2) throws Throwable {
		angularCalculatorPage.multipy(num1, num2);
	}
	
	@When("^I subtract (\\d+) from (\\d+)$")
	public void i_subtract_from(int num1, int num2) throws Throwable {
		angularCalculatorPage.subtract(num1, num2);
	}
	
	@When("^I add (\\d+) plus (\\d+)$")
	public void i_add_plus(int num1, int num2) throws Throwable {
		angularCalculatorPage.add(num1, num2);
	}

	@Then("^I should get (\\d+)$")
	public void i_should_get(int num) throws Throwable {
	    assertThat(angularCalculatorPage.get_result()).isEqualTo(num);
	}
	
	
	
	
}
