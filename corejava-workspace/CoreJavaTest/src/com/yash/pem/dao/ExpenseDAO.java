package com.yash.pem.dao;

import java.util.Date;
import java.util.List;

import com.yash.pem.model.Expense;

/**
 * The Expense DAO interface.
 * @author karoth
 *
 */
public interface ExpenseDAO {

	/**
	 * Inserts a new expense into the database
	 * @param expense to be inserted
	 */
	void insert(Expense expense);
	
	/**
	 * Updates the expense at the indicated position in the database
	 * @param position is the index of the expense
	 * @param newCost is the updated cost
	 * @param newDate is the updated date
	 */
	void update(int position, double newCost, Date newDate);
	
	/**
	 * Returns an ArrayList of the expenses.
	 * @return
	 */
	List<Expense> list();
	
	/**
	 * Returns an ArrayList of the expenses sorted by Month
	 * @return
	 */
	List<Expense> listByMonth();

	/**
	 * Returns an ArrayList of the expenses sorted by Year
	 * @return
	 */
	List<Expense> listByYear();

	/**
	 * Returns an ArrayList of the category ids
	 * @return
	 */
	List<Long> listCategories();
}
