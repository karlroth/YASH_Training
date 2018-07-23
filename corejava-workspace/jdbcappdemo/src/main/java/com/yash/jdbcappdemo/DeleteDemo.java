package com.yash.jdbcappdemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DeleteDemo {
	
	private static Logger logger = Logger.getLogger(InsertDemo.class);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		logger.info("application started!");
		//1. Collection DB Information
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/JDBCDemo";
		String userName="root";
		String password="root";
		//2. Register Driver
		Class c = Class.forName(driverClassName);
		logger.info(c);
		
		//3. Getting /  Creating / setting up connection 
		Connection con = DriverManager.getConnection(url, userName, password);
		logger.info(con);
		//4. Create SQL and execute statement :  transaction
		String sql = "DELETE FROM contacts WHERE id=1";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		logger.info("Success! Record deleted");
		//5. Release Resources , this code should go in finally block
		stmt.close();
		con.close();
		
	}
}
