package com.yash.strassignment.model;

import java.util.Calendar;

public class User {
	private long id = System.currentTimeMillis();
	private String email;
	private String first_name;
	private String last_name;
	private long batch_id;
	private String status;
	private String login_name;
	private String password;
	
	static int year = Calendar.YEAR - 1900;
	
	@Override
	public String toString() {
		return "[id : "+this.id+", name : "+first_name+" "+last_name+", email : "+email+"]";
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String Email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public long getBatchId() {
		return this.batch_id;
	}
	
	public void setBatchId(long batch_id) {
		this.batch_id = batch_id;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLogInName() {
		return this.login_name;
	}
	
	public void setLoginName(String login_name) {
		this.login_name = login_name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
