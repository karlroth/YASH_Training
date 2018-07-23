package com.yash.ota.exception;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {};
	
	public InvalidPasswordException(String errorMessage) {
		super(errorMessage);
	}
	
}
