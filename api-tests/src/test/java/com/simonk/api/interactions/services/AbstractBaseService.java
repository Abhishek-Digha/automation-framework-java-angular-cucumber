package com.simonk.api.interactions.services;

public class AbstractBaseService {

	private final String baseUrl;
	
	
	public AbstractBaseService(String base) {
		baseUrl = base;
	}
	
	public String getBaseUrl() {
		return this.baseUrl;
	}

	



}
