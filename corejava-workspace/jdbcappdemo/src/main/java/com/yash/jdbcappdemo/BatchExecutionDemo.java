package com.yash.jdbcappdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class BatchExecutionDemo {

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
		String sql = "INSERT INTO contacts (name,salary) VALUES (?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, "Karl");
		pstmt.setInt(2, 6000);
		
		pstmt.addBatch();
		
		pstmt.setString(1, "Steve");
		pstmt.setInt(2, 4000);
	
		pstmt.addBatch();
		
		pstmt.executeBatch();
		
		logger.info("Success! Batches added");
		//5. Release Resources , this code should go in finally block
		pstmt.close();
		con.close();
		

	}

	
}
