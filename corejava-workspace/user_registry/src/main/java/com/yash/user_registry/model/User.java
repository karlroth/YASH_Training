package com.yash.user_registry.model;

public class User {

	private long id = System.currentTimeMillis();
	private String name;
	private String login_name;
	private String password;
	
	public String getLoginName() {
		return this.login_name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public void setLoginName(String login_name) {
		this.login_name = login_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
