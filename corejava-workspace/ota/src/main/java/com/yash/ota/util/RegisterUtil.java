package com.yash.ota.util;

import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.exception.FieldEmptyException;
import com.yash.ota.exception.InvalidContactException;
import com.yash.ota.exception.InvalidEmailException;
import com.yash.ota.exception.NonAlphabeticNameException;
import com.yash.ota.model.User;


public class RegisterUtil {


	public static void checkOnlyContainsAlpha(String name) throws NonAlphabeticNameException {
		if (name.matches("^.*[^a-zA-Z].*$")) {
			throw new NonAlphabeticNameException("Name must only contain letters: " + name);
		}
	}

	
	public static void checkForNullOrEmptyFields(User user) throws FieldEmptyException {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		long contact = user.getContact();
		String email = user.getEmail();
		String loginName = user.getLoginName();
		String password = user.getPassword();
		
		if (firstName == null || lastName == null || email == null || loginName == null || password == null) {
			throw new FieldEmptyException("Null fields not allowed");
		}
		if (firstName.equals("") || lastName.equals("") || email.equals("") || contact == 0 || loginName.equals("") || password.equals("")) {
			throw new FieldEmptyException("Empty fields not allowed");
		}
	}


	public static void checkEmailFormat(String email) throws InvalidEmailException {
		String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		if(!email.matches(emailRegex)) {
			throw new InvalidEmailException("Invalid email address.");
		}
		
	}


	public static void checkContactContainsExactlyTenDigits(long contact) throws InvalidContactException {
		if(Long.toString(contact).length() != 10) {
			throw new InvalidContactException("Phone number must be exactly 10 digits long, including area code. Given: "+contact);
		}
	}


	
}
