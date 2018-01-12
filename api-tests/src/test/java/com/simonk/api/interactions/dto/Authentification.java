package com.simonk.api.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Authentification {
	
	@JsonProperty
	private String username;
	@JsonProperty
	private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    private Authentification(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public static class Builder {
    	private String username;
    	private String password;
    	
    	public Builder withUser(String username) {
    		this.username = username;
    		return this;
    	}
    	
    	public Builder withPass(String password) {
    		this.password = password;
    		return this;
    	}
    	
    	public Authentification build() {
    		return new Authentification(username, password);
    	}
    	
    }
    
    
    

}
