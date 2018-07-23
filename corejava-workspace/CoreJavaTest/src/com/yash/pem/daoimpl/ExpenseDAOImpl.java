package com.yash.pem.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.pem.dao.ExpenseDAO;
import com.yash.pem.model.Expense;

/**
 * The implementation of the Expense DAO Interface
 * @author karoth
 *
 */
public class ExpenseDAOImpl implements ExpenseDAO {

	List<Expense> expenseList;
	
	public ExpenseDAOImpl() {
		expenseList = new ArrayList<>();
	}
	
	@Override
	public void insert(Expense expense) {
		expenseList.add(expense);
		
	}

	@Override
	public void update(int position, double newCost, Date newDate) {
		expenseList.get(position).setCost(newCost);
		expenseList.get(position).setDateOfExpense(newDate);
		
	}

	@Override
	public List<Expense> list() {
		return expenseList;
	}

	public List<Expense> listByMonth() {
		List<Expense> byMonth = new ArrayList<>();
		for(int month = 0; month < 12; month++) {
			for(int i = 0; i<expenseList.size(); i++) {
				Expense expense = expenseList.get(i);
				if(expense.getDateOfExpense().getMonth() == month) {
					byMonth.add(expense);
				}
			}
		}
		return byMonth;
		
	}

	@Override
	public List<Expense> listByYear() {
		List<Expense> byYear = new ArrayList<>();
		
		//Checks from 1900 to 2100
		for(int year = 0; year < 200;year++) {
			for(int i = 0; i<expenseList.size(); i++) {
				Expense expense = expenseList.get(i);
				if(expense.getDateOfExpense().getYear() == year) {
					byYear.add(expense);
				}
			}
		}
		return byYear;
	}

	@Override
	public List<Long> listCategories() {
		
		List<Long> categoryIds = new ArrayList<>();
		for(int i = 0; i < expenseList.size(); i++) {
			Expense expense = expenseList.get(i);
			long categoryId = expense.getCategoryId();
			
			if(!categoryIds.contains(categoryId)) {
				categoryIds.add(categoryId);
			}
		}
		return categoryIds;

	}
}
