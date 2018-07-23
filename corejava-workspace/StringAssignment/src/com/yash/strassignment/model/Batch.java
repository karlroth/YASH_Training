package com.yash.strassignment.model;

public class Batch {
	private long id = System.currentTimeMillis();
	private String name; 
	
	public long getId() {
		return this.id;
	}

	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
