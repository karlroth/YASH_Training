package com.yash.mydbtoolassignment;

public class SqlServerTool extends DBTool {

	public void setCredentials(String user_name, String password) {
		super.setCredentials(user_name, password);
	}
	
	public void authenticate() {
		if (getUser().equals("sa") && getPass().equals("admin")) {
			System.out.println("SqlServer>");
			
		} else {
			System.out.println("Invalid username or password.");
		}
	}
	
}
