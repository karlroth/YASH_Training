package com.yash.user_registry.util;

import com.yash.user_registration.exceptions.FieldEmptyException;
import com.yash.user_registration.exceptions.NonAlphabeticNameException;

public class RegisterUtil {


	public static void checkOnlyContainsAlpha(String name) throws NonAlphabeticNameException {
		if (name.matches("^.*[^a-zA-Z].*$")) {
			throw new NonAlphabeticNameException("Name must only contain letters: " + name);
		}
	}

	
	public static void checkIfNullOrEmpty(String name, String login_name, String password)
			throws FieldEmptyException {
		if (name == null || login_name == null || password == null) {
			throw new FieldEmptyException("Null fields not allowed");
		}
		if (name.equals("") || login_name.equals("") || password.equals("")) {
			throw new FieldEmptyException("Empty fields not allowed");
		}
	}
}
