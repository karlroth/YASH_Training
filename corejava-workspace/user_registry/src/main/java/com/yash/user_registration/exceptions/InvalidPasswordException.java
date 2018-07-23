package com.yash.user_registration.exceptions;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {
		
	}
	
public InvalidPasswordException(String errorMessage) {
		super(errorMessage);
	}
}
