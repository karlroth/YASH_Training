package com.yash.mydbtoolassignment;

public class OracleTool extends DBTool {

	
	
	public void setCredentials(String user_name, String password) {
		super.setCredentials(user_name, password);
	}
	
	public void authenticate() {
		if (getUser().equals("scott") && getPass().equals("tiger")) {
			System.out.println("Oracle>");
			
		} else {
			System.out.println("Invalid username or password.");
		}
	}
	
}
