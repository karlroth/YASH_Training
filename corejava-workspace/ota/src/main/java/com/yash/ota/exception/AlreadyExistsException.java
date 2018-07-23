package com.yash.ota.exception;

public class AlreadyExistsException extends Exception {

	public AlreadyExistsException() {
		
	}
	
	public AlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
}
