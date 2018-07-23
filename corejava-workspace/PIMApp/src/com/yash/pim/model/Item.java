package com.yash.pim.model;

import java.util.Date;

/**
 * item is a model, that is used for data transfer
 * @author karoth
 *
 */

public class Item {

	private long id = System.currentTimeMillis();
	
	private long categoryId;
	
	private String name;
	
	private Date purchaseDate;
	
	private double cost;

	public long getId() {
		return id;
	}

	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
	
	
	
	
	
}
