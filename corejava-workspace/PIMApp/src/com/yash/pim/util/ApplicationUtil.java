package com.yash.pim.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationUtil {

	static List<String> mainMenu = new ArrayList<String>() {{
	    add("-------PEM :  Main Menu--------");
	    add("1. Add Category");
	    add("2. List Category");
	    add("3. Delete Category By id");
	    add("4. Edit Category");
	    add("5. Item Entry");
	    add("6. List Items");
	    
	    add("0. Exit");
	}}; 
	
	

	public static List<String> printMenus(String menuName) {
		
		if(menuName.toLowerCase().equals("main menu")) {
			return mainMenu;
		} else {
			return null;
		}
	}
	
	
	public static void printMenu() {
		System.out.println("-------PEM :  Main Menu--------");
		System.out.println("1. Add Category");
		System.out.println("2. List Category");
		System.out.println("3. Delete Category By id");
		System.out.println("4. Edit Category");
		System.out.println("5. Item Entry");
		System.out.println("6. List Items");
		
		System.out.println("0. Exit");
	}
	
	
	public static void exit() {
		System.exit(0);
	}

	public static void pressAnyKeyToContinue() {

		System.out.println("Press any key to Continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
