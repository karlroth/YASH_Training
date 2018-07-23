package com.yash.pem.service;

import java.util.Date;
import java.util.List;

import com.yash.pem.model.Expense;

/**
 * The interface for the Expense Service 
 * @author karoth
 *
 */
public interface ExpenseService {

	/**
	 * Inserts a new expense into the database
	 * @param expense to be inserted
	 */
	void addExpense(Expense expense);
	
	/**
	 * Updates the expense at the indicated position in the database
	 * @param position is the index of the expense
	 * @param newCost is the updated cost
	 * @param newDate is the updated date
	 */
	void editExpense(int position, double newCost, Date newDate);
	
	/**
	 * Returns an ArrayList of the expenses.
	 * @return
	 */
	List<Expense> listExpense();
	
	/**
	 * Returns an ArrayList of the expenses sorted by Month
	 * @return
	 */
	List<Expense> listExpenseByMonth();
	
	/**
	 * Returns an ArrayList of the expenses sorted by Year
	 * @return
	 */
	List<Expense> listExpenseByYear();

	/**
	 * Returns an ArrayList of the category ids
	 * @return
	 */
	List<Long> listExpenseCategories(); 
}
