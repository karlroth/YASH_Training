package com.yash.pim.model;

/**
 * category is a model that is used for data transfer
 * @author karoth
 *
 *
 *
 */

public class Category {

	/**
	 * id of category, auto generated
	 */
	private long id = System.currentTimeMillis();

	/**
	 * name of category
	 */
	private String name;
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.getName() +" - "+this.getId();
	}
}
