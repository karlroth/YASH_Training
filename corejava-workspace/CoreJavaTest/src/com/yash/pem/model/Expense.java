package com.yash.pem.model;

import java.util.Date;
/**
 * Expense
 * @author karoth
 *
 */
public class Expense {

	/**
	 * Id of expense, auto generated
	 */
	private long id = System.currentTimeMillis();
	
	/**
	 * The id of the category this expense belongs to.
	 */
	private long categoryId;
	
	
	/**
	 * The date of the expense entered by the user.
	 */
	private Date dateOfExpense;
	
	/**
	 * The cost of the expense entered by the user. 
	 */
	private double cost;
	
	
	/**
	 * Setter for the category id of the expense.
	 * @param name
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * Setter for the date of the expense
	 * @param dateOfExpense
	 */
	public void setDateOfExpense(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}

	/**
	 * Setter for the cost of the expense.
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Getter for the id of the expense.
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for the category id of the expense.
	 * @return
	 */
	public long getCategoryId() {
		return categoryId;
	}
	
	/**
	 * Getter for the cost of the expense.
	 * @param cost
	 */
	public Date getDateOfExpense() {
		return dateOfExpense;
	}
	
	/**
	 * Getter for the cost of the expense.
	 * @param cost
	 */
	public double getCost() {
		return cost;
	}
	

	
	
	
}
