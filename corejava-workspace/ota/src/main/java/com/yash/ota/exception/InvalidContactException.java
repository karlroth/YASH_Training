package com.yash.ota.exception;

public class InvalidContactException extends Exception {

	public InvalidContactException() {
		
	}
	
	public InvalidContactException(String errorMessage) {
		super(errorMessage);
	}
}
