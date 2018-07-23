package com.yash.user_registration.exceptions;

public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException() {
		
	}
	
	public UserAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
	
}
