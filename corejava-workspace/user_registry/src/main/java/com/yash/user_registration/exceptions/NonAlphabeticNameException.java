package com.yash.user_registration.exceptions;

public class NonAlphabeticNameException extends Exception {

	public NonAlphabeticNameException() {
		
	}
	
	public NonAlphabeticNameException(String errorMessage) {
		super(errorMessage);
	}
}
