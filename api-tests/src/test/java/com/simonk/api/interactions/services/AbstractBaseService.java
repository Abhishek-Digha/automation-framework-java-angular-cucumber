package com.simonk.api.interactions.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractBaseService {

	private final String baseUrl;	
	private final RequestSpecification spec;

	
	
	public AbstractBaseService(String base) {
		baseUrl = base;
		spec = new RequestSpecBuilder()
			.setContentType(ContentType.JSON).setBaseUri(getBaseUrl())
			.addFilter(new AllureRestAssured()).build();
	}
	
	public String getBaseUrl() {
		return this.baseUrl;
	}	
	
	public RequestSpecification getSpec() {
		return this.spec;
	}

	



}
