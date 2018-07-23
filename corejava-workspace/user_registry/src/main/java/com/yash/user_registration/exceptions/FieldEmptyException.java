package com.yash.user_registration.exceptions;

public class FieldEmptyException extends Exception {
	public FieldEmptyException() {
		
	}
	
	public FieldEmptyException(String errorMessage) {
		super(errorMessage);
	}
}
