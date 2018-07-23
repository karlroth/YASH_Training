package com.yash.pem.serviceimpl;

import java.util.Date;
import java.util.List;

import com.yash.pem.dao.ExpenseDAO;
import com.yash.pem.daoimpl.ExpenseDAOImpl;
import com.yash.pem.model.Expense;
import com.yash.pem.service.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseDAO expenseDAO;
	
	public ExpenseServiceImpl() {
		expenseDAO = new ExpenseDAOImpl();
	}
	
	@Override
	public void addExpense(Expense expense) {
		expenseDAO.insert(expense);
		
	}

	@Override
	public void editExpense(int position, double newCost, Date newDate) {
		expenseDAO.update(position, newCost, newDate);
		
	}

	@Override
	public List<Expense> listExpense() {
		return expenseDAO.list();
	}

	@Override
	public List<Expense> listExpenseByMonth() {
		return expenseDAO.listByMonth();
	}

	@Override
	public List<Expense> listExpenseByYear() {
		return expenseDAO.listByYear();
	}

	@Override
	public List<Long> listExpenseCategories() {
		return expenseDAO.listCategories();
	}
	
	

}
