package com.yash.ota.util;

public enum Menu {
	BATCH_MENU, ADD_BATCH, LIST_BATCH, UPDATE_BATCH, REMOVE_BATCH, 
	USER_MENU, REGISTER_USER, AUTHENTICATE_USER, LIST_USER, UPDATE_USER, REMOVE_USER, FIND_USER,
	EXIT, INVALID_OPTION,
	FIRST_NAME,LAST_NAME,EMAIL,CONTACT,LOGIN_NAME;
	
	/**
	 * Converts and integer into an enumeration.
	 * @param choice
	 * @return
	 */
	public static Menu getMainMenuOption(int choice) {
		Menu option = INVALID_OPTION;

		if (choice == 1) {
			option = BATCH_MENU;
		} else if (choice == 2) {
			option = USER_MENU;
		} else if (choice == 0) {
			option = EXIT;
		}
		return option;
	}
	
	/**
	 * Converts and integer into an enumeration.
	 * @param choice
	 * @return
	 */
	public static Menu getBatchMenuOption(int choice) {
		Menu option = INVALID_OPTION;

		if (choice == 1) {
			option = ADD_BATCH;
		} else if (choice == 2) {
			option = LIST_BATCH;
		} else if(choice == 3) {
			option = UPDATE_BATCH;
		} else if(choice == 4) {
			option = REMOVE_BATCH;
		} 
		return option;
	
	}
	
	public static Menu getUserMenuOption(int choice) {
		Menu option = INVALID_OPTION;

		if (choice == 1) {
			option = REGISTER_USER;
		} else if (choice == 2) {
			option = AUTHENTICATE_USER;
		} else if(choice == 3) {
			option = LIST_USER;
		} else if(choice == 4) {
			option = UPDATE_USER;
		} else if(choice == 5) {
			option = REMOVE_USER;
		} else if(choice == 6) {
			option = FIND_USER;
		} 
		return option;
	}
	
	public static Menu getUserPropertyOption(int choice) {
		Menu option = INVALID_OPTION;
		
		if (choice == 1) {
			option = FIRST_NAME;
		} else if (choice == 2) {
			option = LAST_NAME;
		} else if(choice == 3) {
			option = EMAIL;
		} else if(choice == 4) {
			option = CONTACT;
		} else if(choice == 5) {
			option = LOGIN_NAME;
		} 
		return option;
	}

	
}
