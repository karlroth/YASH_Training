package com.yash.tdd_homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordVerifierTest {

	
	@Test(expected = IllegalArgumentException.class)
	public void testVerify_ShortPasswordGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verify("short");
	}
	 
	@Test(expected = IllegalArgumentException.class)
	public void testVerify_NullPasswordGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verify(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerify_LowerCasePasswordGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verify("lowercase");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerify_UpperCasePasswordGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verify("UPPERCASE");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerify_NumberlessPasswordGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verify("numberLess");
	}
	
	@Test
	public void testVerify_PerfectPassordGiven_ShouldNotReturnAnything() throws Exception {
		PasswordVerifier.verify("1goodPass");
	}
	
	
	
	/**
	 * Flexible verifiers
	 */
	@Test
	public void testVerifyFlexible_TooShortGiven_ShouldNotReturnAnything() throws Exception {
		PasswordVerifier.verifyFlexible("2Short");

	}
	
	@Test
	public void testVerifyFlexible_NoNumbersGiven_ShouldNotReturnAnything() throws Exception {
		PasswordVerifier.verifyFlexible("NoNumbers");
	}
	
	@Test
	public void testVerifyFlexible_NoLowerCaseGiven_ShouldNotReturnAnything() throws Exception {
		PasswordVerifier.verifyFlexible("N0LOWERCASE");
	}
	
	@Test
	public void testVerifyFlexible_NoUpperCaseGiven_ShouldNotReturnAnything() throws Exception {
		PasswordVerifier.verifyFlexible("n0uppercase");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerifyFlexible_BadPassGiven_ShouldReturnException() throws Exception {
		PasswordVerifier.verifyFlexible("bad");
	}
	
}
