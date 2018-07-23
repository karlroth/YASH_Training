package com.yash.mydbtoolassignment;



public class MySQLTool extends DBTool {

	public void setCredentials(String user_name, String password) {
		super.setCredentials(user_name, password);
	}
	
	public void authenticate() {
		if (getUser().equals("root") && getPass().equals("admin") ) {
			java.lang.Runtime.exec("MySQL>");
			
		} else {
			System.out.println("Invalid username or password.");
		}
	}
}
