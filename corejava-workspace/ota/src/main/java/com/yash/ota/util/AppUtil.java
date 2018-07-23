package com.yash.ota.util;

import java.util.List;
import java.util.Scanner;

import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.exception.FieldEmptyException;
import com.yash.ota.exception.InvalidContactException;
import com.yash.ota.exception.InvalidEmailException;
import com.yash.ota.exception.InvalidPasswordException;
import com.yash.ota.exception.NonAlphabeticNameException;
import com.yash.ota.exception.UserAuthenticationException;
import com.yash.ota.model.Batch;
import com.yash.ota.model.User;
import com.yash.ota.service.BatchService;
import com.yash.ota.service.UserService;
import com.yash.ota.serviceimpl.BatchServiceImpl;
import com.yash.ota.serviceimpl.UserServiceImpl;

public class AppUtil {

	private static UserService userService = new UserServiceImpl();
	private static BatchService batchService = new BatchServiceImpl();

	private static Scanner sc;
	private static int choice;

	@SuppressWarnings("incomplete-switch")
	public static void launchApplication() {

		sc = new Scanner(System.in);

		while (true) {
			MenuUtil.printMainMenu();
			choice = sc.nextInt();
			Menu option = Menu.getMainMenuOption(choice);

			switch (option) {
			case BATCH_MENU:
				enterBatchMenu();
				break;
			case USER_MENU:
				enterUserMenu();
				break;
			case INVALID_OPTION:
				System.out.println("Invalid selection.");
				break;
			case EXIT:
				System.out.println("Thank you for using the OTA Service!");
				MenuUtil.exit();
			}
			MenuUtil.pressAnyKeyToContinue();
		}
	}

	@SuppressWarnings("incomplete-switch")
	private static void enterBatchMenu() {
		Menu option;
		MenuUtil.printBatchMenu();
		choice = sc.nextInt();
		option = Menu.getBatchMenuOption(choice);
		switch (option) {
		case ADD_BATCH:
			getBatchFromUser();
			break;
		case LIST_BATCH:
			listBatchesForUser();
			break;
		case UPDATE_BATCH:
			updateBatchForUser();
			break;
		case REMOVE_BATCH:
			deleteBatchForUser();
			break;
		case INVALID_OPTION:
			System.out.println("Invalid selection.");
			break;
		}
	}

	private static void updateBatchForUser() {
		System.out.println("Updating Batch...");
		listBatchesForUser();
		System.out.println("Please enter list number of the Batch to be updated: ");
		int index = sc.nextInt();
		if(index < 1 || index > batchService.listBatch().size()) {
			System.out.println("Invalid selection");
			return;
		}
		
		List<Batch> batchList = batchService.listBatch();
		int id = batchList.get(index - 1).getId();

		System.out.print("Enter the new title for the batch: ");
		sc.nextLine();
		String title = sc.nextLine();

		Batch batch = new Batch();
		batch.setId(id);
		batch.setTitle(title);

		try {
			batchService.updateBatch(batch);
			System.out.println("Batch successfully updated!");
			System.out.println();
		} catch (DoesNotExistException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void deleteBatchForUser() {
		System.out.println("--------------------WARNING--------------------");
		System.out.println("This action will permanently delete all users belonging to the batch.");
		System.out.println("Do you wish to continues?");
		System.out.println("1. Yes \n2. No");
		choice = sc.nextInt();
		if(choice != 1) {
			return;
		}
		
		System.out.println("Removing Batch...");
		if (batchService.listBatch().isEmpty()) {
			System.out.println("There are no batches to be deleted.");
		} else {
			listBatchesForUser();
			
			System.out.println("Please enter list number of the Batch to be deleted: ");
			int index = sc.nextInt();
			if(index < 1 || index > batchService.listBatch().size()) {
				System.out.println("Invalid selection");
				return;
			}
			List<Batch> batchList = batchService.listBatch();
			int id = batchList.get(index - 1).getId();

			try {
				List<User> userList = userService.listUsers();
				for (int i = 0; i < userList.size(); i++) {
					User user = userList.get(i);
					if (user.getBatchId() == id) {
						userService.removeUser(user);
					}
				}
				batchService.delete(id);
				System.out.println("Batch successfully deleted!");
			} catch (DoesNotExistException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private static void listBatchesForUser() {
		System.out.println("Listing Batches...");
		List<Batch> batchList = batchService.listBatch();
		if (batchList.isEmpty()) {
			System.out.println("There are currently no batches in the database.");
		} else {
			System.out.println(" Title -- ID");

			for (int i = 0; i < batchList.size(); i++) {
				System.out.println((i + 1) + ". " + batchList.get(i).getTitle() + "\t " + batchList.get(i).getId());
			}
		}
	}

	private static void getBatchFromUser() {
		Batch batch = new Batch();
		System.out.println("Adding Batch...");
		System.out.println("Enter the title for the new Batch");
		sc.nextLine();
		batch.setTitle(sc.nextLine());
		try {
			batchService.addBatch(batch);
			System.out.println("Batch successfully added!");
		} catch (AlreadyExistsException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("incomplete-switch")
	private static void enterUserMenu() {
		Menu option;
		MenuUtil.printUserMenu();
		choice = sc.nextInt();
		option = Menu.getUserMenuOption(choice);

		switch (option) {
		case REGISTER_USER:
			getUserRegistration();
			break;
		case AUTHENTICATE_USER:
			getUserAuthentication();
			break;
		case LIST_USER:
			getUserList();
			break;
		case UPDATE_USER:
			getUpdateUser();
			break;
		case REMOVE_USER:
			getUserToBeRemoved();
			break;
		case FIND_USER:
			findUserByProperty();
			break;
		case INVALID_OPTION:
			System.out.println("Invalid selection.");
			break;
		}
	}

	private static void findUserByProperty() {
		Menu option;
		System.out.println("Finding User...");

		MenuUtil.printUserPropertyMenu();
		System.out.println("Please enter the list number of the property you would like to search by.");
		int choice = sc.nextInt();

		option = Menu.getUserPropertyOption(choice);
		System.out.println("Enter the value the of the chosen property.");
		String property = "";
		Object value = 0;
		switch (option) {
		case FIRST_NAME:
			property = "firstname";
			sc.nextLine();
			value = sc.nextLine();
			break;
		case LAST_NAME:
			property = "lastname";
			sc.nextLine();
			value = sc.nextLine();
			break;
		case EMAIL:
			property = "email";
			sc.nextLine();
			value = sc.nextLine();
			break;
		case CONTACT:
			property = "contact";
			value = sc.nextLong();
			break;
		case LOGIN_NAME:
			property = "loginname";
			sc.nextLine();
			value = sc.nextLine();
			break;
		}

		try {
			User user = userService.findUserByProperty(property, value);
			
			System.out.println("User found!");
			System.out.println("ID -- Batch Title -- Login Name --- Name --- Phone Number -- Email");

			String title = "";
			for (Batch batch : batchService.listBatch()) {
				if (batch.getId() == user.getBatchId()) {
					title = batch.getTitle();
				}
			}
			System.out
					.println(user.getId() + "\t " + title + "  \t  " + user.getLoginName() + "\t" + user.getFirstName()
							+ " " + user.getLastName() + "\t" + user.getContact() + " \t " + user.getEmail());
			System.out.println();
		} catch (DoesNotExistException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void getUpdateUser() {
		System.out.println("Updating User...");
		getUserList();
		System.out.println("Please enter list number of the User to be deleted: ");
		int index = sc.nextInt();
		
		if(index < 1 || index > userService.listUsers().size()) {
			System.out.println("Invalid selection");
			return;
		}
		
		List<User> userList = userService.listUsers();
		User userToBeUpdated = userList.get(index - 1);
		int id = userToBeUpdated.getId();

		listBatchesForUser();
		System.out.print("Enter the list number of the Batch you wish to register the user to: ");
		index = sc.nextInt();
		
		int batchId = batchService.listBatch().get(index - 1).getId();
		System.out.println();
		System.out.println("Please enter the following information for the new user: ");

		System.out.println("First name: ");
		sc.nextLine();
		String firstName = sc.nextLine();

		System.out.println("Last name: ");
		String lastName = sc.nextLine();

		System.out.println("Email: ");
		String email = sc.nextLine();

		System.out.println("Phone number: ");
		long contact = sc.nextLong();

		System.out.println("Login name: ");
		sc.nextLine();
		String loginName = sc.nextLine();

		System.out.println("Password: ");
		String password = sc.nextLine();

		User user = new User();
		user.setId(id);
		user.setBatchId(batchId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setContact(contact);
		user.setLoginName(loginName);
		user.setPassword(password);

		try {
			userService.updateUser(user);
			System.out.println("User successfully updated!");
		} catch (DoesNotExistException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void getUserToBeRemoved() {
		System.out.println("Removing User...");
		getUserList();
		System.out.println("Please enter list number of the User to be deleted: ");
		int index = sc.nextInt();
		if(index < 1 || index > userService.listUsers().size()) {
			System.out.println("Invalid selection");
			return;
		}
		
		List<User> userList = userService.listUsers();
		User userToBeDeleted = userList.get(index - 1);

		try {
			userService.removeUser(userToBeDeleted);
			System.out.println("User successfully deleted!");
		} catch (DoesNotExistException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void getUserList() {
		System.out.println("Listing Users...");

		List<User> userList = userService.listUsers();

		if (userList.isEmpty()) {
			System.out.println("There are currently no users in the database.");
			System.out.println();
		} else {
			System.out.println(" ID -- Batch Title -- Login Name --- Name --- Phone Number -- Email");

			for (int i = 0; i < userList.size(); i++) {
				int batchId = userList.get(i).getBatchId();
				String title = "";
				for (Batch batch : batchService.listBatch()) {
					if (batch.getId() == batchId) {
						title = batch.getTitle();
					}
				}
				System.out.println((i + 1) + ". " + userList.get(i).getId() + "\t " + title + "  \t  "
						+ userList.get(i).getLoginName() + "\t" + userList.get(i).getFirstName() + " "
						+ userList.get(i).getLastName() + "\t" + userList.get(i).getContact() + " \t "
						+ userList.get(i).getEmail());
			}
		}
	}

	private static void getUserAuthentication() {
		System.out.println("Authenticating User...");

		System.out.println("Enter the login name: ");
		sc.nextLine();
		String loginName = sc.nextLine();

		System.out.println("Enter the password: ");
		String password = sc.nextLine();

		try {
			User user = userService.authenticateUser(loginName, password);
			System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
		} catch (UserAuthenticationException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void getUserRegistration() {
		System.out.println("Registering User...");
		if (batchService.listBatch().isEmpty()) {
			System.out.println(
					"There are currently no batches available. Please create a batch first using the Batch Menu.");
		} else {

			listBatchesForUser();
			System.out.print("Enter the list number of the Batch you wish to register the user to: ");
			int index = sc.nextInt();

			int batchId = batchService.listBatch().get(index - 1).getId();
			System.out.println();
			System.out.println("Please enter the following information for the new user: ");

			System.out.println("First name: ");
			sc.nextLine();
			String firstName = sc.nextLine();

			System.out.println("Last name: ");
			String lastName = sc.nextLine();

			System.out.println("Email: ");
			String email = sc.nextLine();

			System.out.println("Phone number: ");
			long contact = sc.nextLong();

			System.out.println("Login name: ");
			sc.nextLine();
			String loginName = sc.nextLine();

			System.out.println("Password: ");
			String password = sc.nextLine();

			System.out.println("Confirm password: ");
			String confirmationPassword = sc.nextLine();

			if (password.equals(confirmationPassword)) {
				try {

					User user = new User();
					user.setBatchId(batchId);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setEmail(email);
					user.setContact(contact);
					user.setLoginName(loginName);
					user.setPassword(password);

					userService.registerUser(user);

					System.out.println("User successfully register!");
				} catch(FieldEmptyException ex) {
					System.out.println(ex.getMessage());
				} catch (InvalidPasswordException ex) {
					System.out.println(ex.getMessage());
				} catch (NonAlphabeticNameException ex) {
					System.out.println(ex.getMessage());
				} catch (AlreadyExistsException ex) {
					System.out.println(ex.getMessage());
				} catch (InvalidEmailException ex) {
					System.out.println(ex.getMessage());
				} catch (InvalidContactException ex) {
					System.out.println(ex.getMessage());
				} 
					

			} else {
				System.out.println("Passwords must match. Please try again.");
			}

		}
	}

}
