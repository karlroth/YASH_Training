package com.yash.jdbcappdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class QueryDemo {

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
		String sql = "SELECT * FROM contacts";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("column count: " +rsmd.getColumnCount());
		System.out.println("first Column name: "+rsmd.getColumnName(1));
		System.out.println("first Column type: "+rsmd.getColumnType(1));
		System.out.println("table name: "+rsmd.getTableName(1));
		
		while(rs.next()) {
			System.out.print("name: " +rs.getString("name")+" ----  ");
			System.out.println("salary: " +rs.getInt("salary"));
		}
		
		
		
		logger.info("Success! Record queried");
		//5. Release Resources , this code should go in finally block
		stmt.close();
		con.close();
	}
}
