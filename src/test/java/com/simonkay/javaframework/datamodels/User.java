package com.simonkay.javaframework.datamodels;

public class User {

	private String username;
	private String password;
	private String userDescription;

	public User() {
		this.username = "angular";
		this.password = "password";
		this.userDescription = "angular";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
