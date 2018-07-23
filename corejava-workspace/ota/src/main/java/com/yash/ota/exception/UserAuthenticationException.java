package com.yash.ota.exception;

public class UserAuthenticationException extends Exception {

	public UserAuthenticationException() {
		
	}
	public UserAuthenticationException(String errorMessage) {
		super(errorMessage);
	}
}
