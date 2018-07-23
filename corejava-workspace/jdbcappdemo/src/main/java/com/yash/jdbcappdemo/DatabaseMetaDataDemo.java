package com.yash.jdbcappdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseMetaDataDemo {

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
		
		DatabaseMetaData dbmd = con.getMetaData(); 
		System.out.println("Vendor: "+dbmd.getDatabaseProductName());
		System.out.println("Version: "+dbmd.getDatabaseMajorVersion());
		System.out.println("Driver: "+dbmd.getDriverName());
		System.out.println("url: "+dbmd.getURL());
		System.out.println("username: "+dbmd.getUserName());

		con.close();
	}
}
