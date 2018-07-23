package com.yash.ota.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MenuUtil {

	private static File menuFile = new File("menus.txt");
	
	/**
	 * Prints the Main Menu of the Application.
	 */
	public static void printMainMenu() {
		try {
			boolean flag = false;
			FileReader fr = new FileReader(menuFile);
			BufferedReader br = new BufferedReader(fr);
			String menuLine = br.readLine();
			while (menuLine != null) {
				if (menuLine.contains("-Main Menu-")) {
					flag = true;
				} else if (menuLine.contains("*")) {
					flag = false;
				}
				if (flag) {
					System.out.println(menuLine);
				}
				menuLine = br.readLine();
			}
			br.close();
		} catch (IOException ex) {
			ex.getStackTrace();
		}
		
		System.out.println("Enter your option: ");
	}
	
	/**
	 * Prints the menu related to the User CRUD.
	 */
	public static void printUserMenu() {
		try {
			boolean flag = false;
			FileReader fr = new FileReader(menuFile);
			BufferedReader br = new BufferedReader(fr);
			
			String menuLine = br.readLine();
			while (menuLine != null) {
				if (menuLine.contains("-User Menu-")) {
					flag = true;
				} else if (menuLine.contains("*")) {
					flag = false;
				}
				if (flag) {
					System.out.println(menuLine);
				}
				menuLine = br.readLine();
			}
			br.close();
		} catch (IOException ex) {
			ex.getStackTrace();
		}
		
		System.out.println("Enter your option: ");
	}

	/**
	 * Prints the menu related to the Batch CRUD.
	 */
	public static void printBatchMenu() {
		try {
			boolean flag = false;
			FileReader fr = new FileReader(menuFile);
			BufferedReader br = new BufferedReader(fr);
			
			String menuLine = br.readLine();
			while (menuLine != null) {
				if (menuLine.contains("-Batch Menu-")) {
					flag = true;
				} else if (menuLine.contains("*")) {
					flag = false;
				}
				if (flag) {
					System.out.println(menuLine);
				}
				menuLine = br.readLine();
			}
			br.close();
		} catch (IOException ex) {
			ex.getStackTrace();
		}
		
		System.out.println("Enter your option: ");
	}
	
	public static void printUserPropertyMenu() {
		try {
			boolean flag = false;
			FileReader fr = new FileReader(menuFile);
			BufferedReader br = new BufferedReader(fr);
			
			String menuLine = br.readLine();
			while (menuLine != null) {
				if (menuLine.contains("-User Properties-")) {
					flag = true;
				} else if (menuLine.contains("*")) {
					flag = false;
				}
				if (flag) {
					System.out.println(menuLine);
				}
				menuLine = br.readLine();
			}
			br.close();
		} catch (IOException ex) {
			ex.getStackTrace();
		}
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
