package com.yash.pem.model;
/**
 * Category is a model that is used for data transfer. 
 * @author karoth
 * 
 */

public class Category {


	/**
	 * Id of category, auto generated
	 */
	private long id = System.currentTimeMillis();

	/**
	 * Name of category
	 */
	private String name;
	

	/**
	 * Getter for the name variable
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name variable
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter for the id variable
	 * @return
	 */
	public long getId() {
		return this.id;
	}
}
