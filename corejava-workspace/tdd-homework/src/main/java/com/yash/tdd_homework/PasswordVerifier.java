package com.yash.tdd_homework;

public class PasswordVerifier {

	public static void verify(String string) {
		checkNull(string);
		checkLength(string);
		hasLowerCase(string);
		hasUpperCase(string);
		hasNumber(string);
	}
	
	public static void verifyFlexible(String string) {
		checkNull(string);
		boolean tooShort = string.length() < 8;
		boolean hasLowerCase = !string.equals(string.toUpperCase());
		boolean hasUpperCase = !string.equals(string.toLowerCase());
		boolean hasNumber = string.matches(".*\\d+.*");
		
		System.out.println("tooShort = "+tooShort);
		System.out.println("hasLowerCase = "+hasLowerCase);
		System.out.println("hasUpperCase = "+hasUpperCase);
		System.out.println("hasNumber = "+hasNumber);
		
		boolean valid = false;
		
		if(hasNumber && hasUpperCase && hasLowerCase) {
			valid = true;
		} else if(!tooShort && hasNumber && hasLowerCase) {
			valid = true;
		} else if(!tooShort && hasUpperCase && hasLowerCase) {
			valid = true;
		} else if(!tooShort && hasNumber && hasUpperCase) {
			valid = true;
		} 
		
		if(!valid) {
			throw new IllegalArgumentException();
		}
		
	}

	private static void hasNumber(String string) {
		if(!string.matches(".*\\d+.*")) {
			throw new IllegalArgumentException("Password must contain at least one number");
		}
	}

	private static void hasUpperCase(String string) {
		if(string.equals(string.toLowerCase())) {
			throw new IllegalArgumentException("Password must contain at least one upper case character");
		}
	}

	private static void hasLowerCase(String string) {
		if(string.equals(string.toUpperCase())) {
			throw new IllegalArgumentException("Password must containt at least one lower case character");
		}
	}

	private static void checkLength(String string) {
		if(string.length() < 8) {
			throw new IllegalArgumentException("Password must be atleast 8 characters long");
		}
	}

	private static void checkNull(String string) {
		if( string == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
	}

}
