package com.simonk.api.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Authentification {
	
	@JsonProperty
	private String user;
	@JsonProperty
	private String pass;
	

    public String getuser() {
        return user;
    }

    public String getpass() {
        return pass;
    }
    
    private Authentification(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public static class Builder {
    	private String user;
    	private String pass;
    	
    	public Builder withUser(String user) {
    		this.user = user;
    		return this;
    	}
    	
    	public Builder withPass(String pass) {
    		this.pass = pass;
    		return this;
    	}
    	
    	public Authentification build() {
    		return new Authentification(user, pass);
    	}
    	
    }

	@Override
	public String toString() {
		return "Authentification [user=" + user + ", pass=" + pass + "]";
	}
    
    
    

}
