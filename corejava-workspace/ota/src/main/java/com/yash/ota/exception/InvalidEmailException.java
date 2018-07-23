package com.yash.ota.exception;

public class InvalidEmailException extends Exception {

	public InvalidEmailException() {}
	
	public InvalidEmailException(String errorMessage) {
		super(errorMessage);
	}

}
