package com.yash.pem.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yash.pem.model.Category;
import com.yash.pem.model.Expense;
import com.yash.pem.service.CategoryService;

/**
 * 
 * @author karoth
 *
 * A class to house all of the utility methods used in the StartupApplication.
 * 
 */
public class AppUtil {

	/**
	 * The main menu of the StartupApplication in ArrayList form.
	 */
	static List<String> mainMenu = new ArrayList<String>() {{
	    add("Add Category");
	    add("List Category");
	    add("Add Expense (Category Wise)");
	    add("Expense List");
	    add("Edit Expense");
	    add("Report");
	    
	}}; 
	/**
	 * The report menu of the StartupApplication in ArrayList form.
	 */
	static List<String> reportMenu = new ArrayList<String>() {{
		add("Monthly Expense");
		add("Yearly Expense");
		add("Category Wise Expense");
		
	}};

	/**
	 * Returns the arrayList Menu.
	 * @param menuName is the name of the menu to be returned. 
	 */
	private static List<String> getMenu(String menuName) {
		
		if(menuName.toLowerCase().equals("main menu")) {
			return mainMenu;
		} else if(menuName.toLowerCase().equals("report menu")) {
			return reportMenu;
		} else {
			return null;
		}
	}
	
	/**
	 * Prints the menu that is recieved as an arrayList.
	 * @param menu
	 */
	public static void printList(List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			String listItem = list.get(i);
			System.out.println((i+1)+". "+listItem);
		}
	}

	/**
	 * Prints the categories in the parameter catList
	 * @param catList
	 */
	public static void printCategories(List<Category> catList) {
		for (int i = 0; i < catList.size(); i++) {
			Category category = catList.get(i);
			System.out.println((i + 1) + ". " + category.getName() + " - " + category.getId());
		}
	}	
	
	/**
	 * Prints out a generic Expense List
	 * @param expenseList
	 * @param categoryService 
	 */
	public static void printExpense(List<Expense> expenseList, CategoryService categoryService) {
		System.out.println("expense id   \t   category name  \t expense cost \t purchase date");
		System.out.println("==============================================================================");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		

		for(int i=0;i<expenseList.size(); i++) {
			Expense expense = expenseList.get(i);
			System.out.println((i+1)+". " 
					+ expense.getId() 
					+ "   -   "
					+ categoryService.getCategoryNameFromId(expense.getCategoryId()) 
					+ "   -   "
					+ expense.getCost()
					+ "   -   "
			+ sdf.format(expense.getDateOfExpense()));
			
		}
	}
	
	/**
	 * Prints the "Main Menu"
	 */
	public static void printMainMenu() {
		System.out.println("--------Main Menu---------");
		List<String> mainMenu = AppUtil.getMenu("main menu");
		printList(mainMenu);
		System.out.println("0. Exit");
	}
	
	/**
	 * Prints the "Report Menu"
	 */
	public static void printReportMenu() {
		System.out.println("--------Report Menu---------");
		List<String> reportMenu = AppUtil.getMenu("report menu");
		printList(reportMenu);
		
	}

	/**
	 * Prompt used to cycle through the menu after a command has been performed.
	 */
	public static void pressAnyKeyToContinue() {

		System.out.println("Press any key to Continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to exit the program.
	 */
	public static void exit() {
		System.exit(0);
	}
	
	
	
	
}
