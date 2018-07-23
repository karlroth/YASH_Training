package com.yash.user_registry.util;

import com.yash.user_registration.exceptions.InvalidPasswordException;

public class PasswordUtil {


	public static void checkPasswordMeetsCriterion(String password) throws InvalidPasswordException {
		checkLength(password);
		checkContainsUpperCase(password);
		checkContainsSpecialCharacter(password);
		checkForWhiteSpace(password);
	}
	
	private static void checkForWhiteSpace(String password) throws InvalidPasswordException {
		if (password.contains(" ")) {
			throw new InvalidPasswordException("Password cannot contain white space: " + password);
		}
	}

	private static void checkContainsSpecialCharacter(String password) throws InvalidPasswordException {
		if (!password.matches("^.*[^a-zA-Z0-9 ].*$")) {
			throw new InvalidPasswordException("Password must contain at least one special character: " + password);
		}
	}

	private static void checkContainsUpperCase(String password) throws InvalidPasswordException {
		if (password.equals(password.toLowerCase())) {
			throw new InvalidPasswordException("Password must contain at least one capital letter: " + password);
		}
	}

	private static void checkLength(String password) throws InvalidPasswordException {
		if (password.length() < 8 || password.length() > 15) {
			throw new InvalidPasswordException("Password must be between 8 and 15 characters long: " + password);
		}
	}

	/* Password Confirmation delegated to startup application.
	private static void passwordConfirmation(String password, String confirm_password) throws InvalidPasswordException {
		if (!password.equals(confirm_password)) {
			throw new InvalidPasswordException("Passwords must match");
		}
	}
	 */

}
