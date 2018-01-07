package com.simonkay.javaframework.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.simonkay.javaframework.datamodels.Order;
import com.simonkay.javaframework.datamodels.User;
import com.simonkay.javaframework.dataproviders.DataProviderInjector;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GeneralSteps extends AbstractBaseStepDefinition {
	
	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}
	

	@Given("^The order \"([^\"]*)\" exists$")
	public void the_order_exists(String orderAlias) throws Throwable {
		Order order = new Order("Credit card", new DataProviderInjector());
		cucumberWorld.addNewOrder(orderAlias, order);    
	}
	
	@Given("The user \"([^\"]*)\" exists$") 
	public void the_user_exists(String userAlias) throws Throwable {
		User user = new User();
		cucumberWorld.addNewUser(userAlias, user);		
	}
	
	@Then("^i force a fail$")
	public void i_force_a_fail() throws Throwable {
		assertThat(false).isTrue();
	}

}
