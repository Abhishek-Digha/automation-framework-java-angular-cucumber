package com.simonkay.javaframework.configurations;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simonkay.javaframework.datamodels.Order;
import com.simonkay.javaframework.datamodels.User;

public class CucumberWorld {
	private static final Logger LOG = LogManager.getLogger(CucumberWorld.class);
	
	public HashMap<String, String> stepDefinitionState = new HashMap<String, String>();
	private HashMap<String, Object> stateObjects = new HashMap<String, Object>();
	
	
	public HashMap<String, Object> getStateObjects() {
		return stateObjects;
	}
	
	public void addNewOrder(String orderAlias, Order order) {
		LOG.debug("Adding new order to cucumber world with alias: " + orderAlias + ". Order: " + order.toString());
		stateObjects.put(orderAlias, order);
	}
	
	public Order getOrderByAlias(String orderAlias) {
		LOG.debug("Retrieving order from cucumber world with alias: " + orderAlias);
		if (stateObjects.get(orderAlias) instanceof Order) {
			LOG.debug("Alias is infact an Order, casting from Obj to Order");
			return (Order) stateObjects.get(orderAlias);
		}
		LOG.fatal("ATTEMPTING TO RETRIEVE AN INCORRECT OBJECT TYPE FROM THE WORLD, IT WAS NOT AN INSTANCE OF ORDER, RETURNING NULL");
		return null;		
	}
	
	public void addNewUser(String userAlias, User user) {
		LOG.debug("Adding new user to cucumber world with alias: " + userAlias + ". User: " + user.toString());
		stateObjects.put(userAlias, user);
	}
	
	public User getUserByAlias(String userAlias) {
		LOG.debug("Retrieving user from cucumber world with alias: " + userAlias);
		if (stateObjects.get(userAlias) instanceof User) {
			LOG.debug("Alias is infact a User, casting from Obj to User");
			return (User) stateObjects.get(userAlias);
		}
		LOG.fatal("ATTEMPTING TO RETRIEVE AN INCORRECT OBJECT TYPE FROM THE WORLD, IT WAS NOT AN INSTANCE OF USER, RETURNING NULL");
		return null;		
	}
	
	
	
}
