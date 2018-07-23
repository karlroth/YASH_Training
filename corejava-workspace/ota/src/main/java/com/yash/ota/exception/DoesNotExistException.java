package com.yash.ota.exception;

public class DoesNotExistException extends Exception {

	public DoesNotExistException() {
		
	}
	public DoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
