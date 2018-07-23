package com.yash.user_registry.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yash.user_registration.exceptions.FieldEmptyException;
import com.yash.user_registration.exceptions.InvalidPasswordException;
import com.yash.user_registration.exceptions.NonAlphabeticNameException;
import com.yash.user_registration.exceptions.UserAlreadyExistsException;
import com.yash.user_registration.exceptions.UserAuthenticationException;
import com.yash.user_registry.dao.UserDAO;
import com.yash.user_registry.daoimpl.UserDAOImpl;
import com.yash.user_registry.model.User;
import com.yash.user_registry.service.UserService;
import com.yash.user_registry.serviceimpl.UserServiceImpl;

/**
 * A class to house all of the utility methods used in the StartupApplication.
 *
 * @author karoth4
 */
public class ApplicationUtil {

	private static UserDAO userDAO = new UserDAOImpl();
	private static UserService userService = new UserServiceImpl(userDAO);
	static Scanner sc;

	public static void startUp() {
		sc = new Scanner(System.in);
		while (true) {
			printMenu();
			System.out.println("Enter your option: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				getRegisterationInfoFromUser();
				break;
			case 2:
				getLoginInfoFromUser();
				break;
			case 0:
				System.out.println("Thank you for using the User Registration Service!");
				exit();
			}
			pressAnyKeyToContinue();
		}
	}

	private static void getLoginInfoFromUser() {
		System.out.println("----Login----");

		System.out.print("Please enter your login_name: ");
		sc.nextLine();
		String login_name = sc.nextLine();

		System.out.print("Please enter your password: ");
		String password = sc.nextLine();

		try {
			userService.login(login_name, password);
		} catch (UserAuthenticationException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getRegisterationInfoFromUser() {
		System.out.println("----Register User----");

		System.out.print("Please enter your legal name: ");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.print("Please choose a login name: ");
		String login_name = sc.nextLine();

		System.out.print("Enter your password: ");
		String password = sc.nextLine();

		System.out.print("Confirm the password: ");
		String confirm_password = sc.nextLine();

		try {
			if (!password.equals(confirm_password)) {
				throw new InvalidPasswordException("Passwords must be the same: " + password);
			}

			User user = new User();
			user.setName(name);
			user.setLoginName(login_name);
			user.setPassword(password);

			userService.registerUser(user);
			System.out.println("User successfully registered!");
		} catch (InvalidPasswordException e) {
			System.out.println("User not registered");
			System.out.println(e.getMessage());
		} catch (FieldEmptyException e) {
			System.out.println("User not registered");
			System.out.println(e.getMessage());
		} catch (NonAlphabeticNameException e) {
			System.out.println("User not registered");
			System.out.println(e.getMessage());
		} catch (UserAlreadyExistsException e) {
			System.out.println("User not registered");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * The main menu of the StartupApplication in ArrayList form.
	 */
	static List<String> mainMenu = new ArrayList<String>() {
		{
			add("Register User");
			add("Login");
		}
	};

	/**
	 * Prints the "Main Menu"
	 */
	public static void printMenu() {
		System.out.println("------ MAIN MENU ------");
		int i = 1;
		for (String element : mainMenu) {
			System.out.println(i + ". " + element);
			i++;
		}
		System.out.println("0. Exit");
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
