package com.yash.mydbtoolassignment;

//import com.yash.mydbtoolassignment.MySQLTool;

public class MyDBTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String objectType = args[0];
		String user_name = args[1];
		String password = args[2];
		
		Object database = Class.forName("com.yash.mydbtoolassignment."+objectType+"Tool").newInstance();
		//DBTool database = new DBTool(user_name, password);
		
		
		if(database instanceof MySQLTool) {
			MySQLTool mysql = (MySQLTool) database;
			mysql.setCredentials(user_name, password);
			mysql.authenticate();
			
		} else if(database instanceof OracleTool) {
			OracleTool oracle = (OracleTool) database;
			oracle.setCredentials(user_name, password);
			oracle.authenticate();
			
		} else if(database instanceof SqlServerTool) {
			SqlServerTool sqlServer = (SqlServerTool) database;
			sqlServer.setCredentials(user_name, password);
			sqlServer.authenticate();
			
		} else {
			System.out.println("Invalid server name.");
			System.out.println("Please enter either MySQL, Oracle, or SqlServer followed by the username and password.");
		}
		
		
	}
	
}
