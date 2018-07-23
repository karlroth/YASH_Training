package com.yash.mydbtoolassignment;

public class DBTool {

	private String user_name;
	private String password;
	
	public DBTool() {
		
	}
	
	public DBTool(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}
	
	public void setCredentials(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
		
	}
	
	public String getUser() {
		return this.user_name;
	}
	
	public String getPass() {
		return this.password;
	}
}

