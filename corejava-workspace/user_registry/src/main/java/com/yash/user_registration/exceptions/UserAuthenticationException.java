package com.yash.user_registration.exceptions;

public class UserAuthenticationException extends Exception {

	
	public UserAuthenticationException() {
		
	}
	
	public UserAuthenticationException(String errorMessage) {
		super(errorMessage);
	}
}
