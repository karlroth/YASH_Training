package com.yash.ota.exception;

public class FieldEmptyException extends Exception {

	public FieldEmptyException() {
		
	}
	
	public FieldEmptyException(String errorMessage) {
		super(errorMessage);
	}
}
