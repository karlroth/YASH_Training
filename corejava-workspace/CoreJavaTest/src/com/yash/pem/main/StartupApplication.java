package com.yash.pem.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yash.pem.model.Category;
import com.yash.pem.model.Expense;
import com.yash.pem.service.CategoryService;
import com.yash.pem.service.ExpenseService;
import com.yash.pem.serviceimpl.CategoryServiceImpl;
import com.yash.pem.serviceimpl.ExpenseServiceImpl;
import com.yash.pem.util.AppUtil;



/**
 * The main method for the Personal Expense Management (PEM) Application.
 * @author karoth
 *
 */
public class StartupApplication {

	private static CategoryService categoryService = new CategoryServiceImpl();
	private static ExpenseService expenseService = new ExpenseServiceImpl();
	
	private static Scanner sc;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args ) {
		
		sc = new Scanner(System.in);
	
		while (true) {
			AppUtil.printMainMenu();
			System.out.println("Enter your option: ");
				int choice = sc.nextInt();	
			switch (choice) {
			case 1:
				getCategoryFromUser();
				break;
			case 2:
				listCategoriesAddedByUser();
				break;
			case 3: 
				getExpenseFromUser();
				break;
			case 4: 
				listExpensesAddedByUser();
				break;
			case 5:
				updateExpenseByRowNumber();
				break;
			case 6:
				AppUtil.printReportMenu();
				System.out.println("Enter your option : ");
				getReportForUser(sc.nextInt());
				break;
			case 0:
				AppUtil.exit();
			}
			AppUtil.pressAnyKeyToContinue();
		}
	}

	/**
	 * A switch function that is used in reponse to the Report Menu prompt.
	 * @param choice 
	 */
	private static void getReportForUser(int choice) {
		switch ( choice ) {
		case 1:
			getMonthlyReport();
			break;
		case 2:
			getYearlyReport();
			break;
		case 3:
			getCategoryReport();
			break;
		}
		System.out.println();
		System.out.println("Returning to Main Menu");
	}

	/**
	 * Prints a report in the following format
	 * 
	 * expense id | category name | expense cost | purchase date
	 * 
	 * Sorted by category. 
	 */
	private static void getCategoryReport() {
		System.out.println("------Category Expenses------");
		
		List<Long> categoryIds = expenseService.listExpenseCategories();
		List<Expense> byCategory = new ArrayList<>();
		List<Expense> expenseList = expenseService.listExpense();
		
		for(int i = 0; i < categoryIds.size(); i++) {
			for(int j = 0; j < expenseList.size(); j++) {
				Expense expense = expenseList.get(j);
				if(expense.getCategoryId() == categoryIds.get(i) ) {
					byCategory.add(expense);
				}
			}
		}
		
		System.out.println("Enter the name of the category you want to view: ");
		sc.nextLine();
		String category = sc.nextLine();
		
		List<Expense> categories = new ArrayList<>();

		for(int i=0; i<byCategory.size(); i++) {
			Expense expense = byCategory.get(i);
			
			if(categoryService.getCategoryNameFromId(expense.getCategoryId()).equals(category)) {
				categories.add(expense);
			
			}
		}
		
		AppUtil.printExpense(categories, categoryService);
	}

	/**
	 * Prints a report in the following format.
	 * 
	 * expense id | category name | expense cost | purchase date
	 * 
	 * Sorted by year in an ascending fashion.
	 */
	private static void getYearlyReport() {
		System.out.println("------Yearly Expenses------");
		System.out.println("Please enter the year you want to view");
		
		int year =sc.nextInt();
		
		List<Expense> sortedByYear = expenseService.listExpenseByYear();
		
		List<Expense> byYear = new ArrayList<>();
		
		for(int i=0; i<sortedByYear.size(); i++) {
			Expense expense = sortedByYear.get(i);
			
			if(expense.getDateOfExpense().getYear() == year-1900) {
				byYear.add(expense);
			
			}
		}
		
		AppUtil.printExpense(byYear, categoryService);
		
	}

	 /**Prints a report in the following format.
	 * 
	 * expense id | category name | expense cost | purchase date
	 * 
	 * Sorted by month in an ascending fashion.
	 */
	private static void getMonthlyReport() {
		System.out.println("------Monthly Expenses------");
		
		System.out.println("Enter the month you want to view as a number: ");
		int month = sc.nextInt();
		
		List<Expense> sortedByMonth = expenseService.listExpenseByMonth();
		
		List <Expense> byMonth = new ArrayList<>();

		for(int i=0; i<sortedByMonth.size(); i++) {
			Expense expense = sortedByMonth.get(i);
			
			if(expense.getDateOfExpense().getMonth() == month-1) {
				byMonth.add(expense);
	
			}
		}
		
		
		AppUtil.printExpense(byMonth, categoryService);

	}
	
	/**
	 * Prints expense list, and then updates the cost and date.
	 */
	private static void updateExpenseByRowNumber() {
		System.out.println("------Editing Expense------");
		listExpensesAddedByUser();
		
		System.out.println("Enter the row number of the Expense you want to update.");
		int position = sc.nextInt();
		
		int index = expenseService.listExpense().size() - position;
		
		System.out.println("Enter the new cost of the expense: ");
		double newCost = sc.nextDouble();
		
		System.out.println("Enter the new date of the number in the format dd-MM-yyyy : ");
		sc.nextLine();

		StringBuffer date = new StringBuffer(sc.nextLine());
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6, 10));
		
		Date newDate = new Date(year-1900, month-1, day);
		
		expenseService.editExpense(index, newCost, newDate);
		
		System.out.println("Success! Expense updated...");
		
	}

	/**
	 * Lists all of the expenses that have been added by the user with the most recent being listed first
	 */
	private static void listExpensesAddedByUser() {
		System.out.println("-------Listing Expenses------");
		List<Expense> expenses = expenseService.listExpense();
		
		System.out.println("expense id   \t   category name  \t expense cost \t purchase date");
		System.out.println("==============================================================================");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		int serial = 1;
		
		for(int i = expenses.size() - 1; i >= 0; i--) {
			Expense expense = expenses.get(i);
			System.out.println(serial+". " 
			+ expense.getId() 
			+ "   -   "
			+ categoryService.getCategoryNameFromId(expense.getCategoryId()) 
			+ "   -   "
			+ expense.getCost()
			+ "   -   "
			+ 
			sdf.format(expense.getDateOfExpense()));
					
			serial++;
		}
		
	}
	
	/**
	 * Allows the user to add a new expense under a specific category
	 */
	private static void getExpenseFromUser() {

		if(categoryService.listCategory().isEmpty()) {
			System.out.println("There are currently no categories. Add a category first.");
			System.out.println();
		} else {
			System.out.println("------Adding Expense------");

			listCategoriesAddedByUser();
			System.out.println("Enter the list number of the category that the item belongs to :");
			int position = sc.nextInt();
			Category category = categoryService.listCategory().get(position - 1);

			category.getId();

			Expense expense = new Expense();
			
			System.out.println("Enter the cost of the expense: ");
			expense.setCost(sc.nextDouble());

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Enter the date that the expense occured as dd-MM-yyyy: ");
			sc.nextLine();

			StringBuffer date = new StringBuffer(sc.nextLine());
			
			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(3, 5));
			int year = Integer.parseInt(date.substring(6, 10));

			expense.setDateOfExpense(new Date(year-1900, month-1, day));
			expense.setCategoryId(category.getId());

			expenseService.addExpense(expense);
		}
		System.out.println("Success! Expense added...");
		
	}


	/**
	 * Lists all of the categories added by the user
	 */
	private static void listCategoriesAddedByUser() {
		System.out.println("------Listing Categories-------");
		if(categoryService.listCategory().isEmpty()) {
			System.out.println("There are currently no categories. Add a category first.");
			System.out.println();
		} else {
			
			List<Category> catList = categoryService.listCategory();
			for (int i = 0; i < catList.size(); i++) {
				Category category = catList.get(i);
				System.out.println((i + 1) + ". " + category.getName() + " - " + category.getId());
			}
		}	
	}

	
	/**
	 * Allows the user to add a new category
	 */
	private static void getCategoryFromUser() {
		sc.nextLine();
		System.out.println("------Adding Category------");
		System.out.println("Enter Category Name : ");
		
		String catName = sc.nextLine();
		Category category = new Category();
		category.setName(catName);
		categoryService.addCategory(category);
		
		System.out.println("Success! Category added...");
		
	}
	
	

	
}
