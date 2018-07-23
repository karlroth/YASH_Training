package com.yash.tdd_demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCaclulatorTest {
	
	private final String ANY_SINGLE_VALUE_AS_STRING = "5";
	private StringCalculator stringCalculator;
	
	@Before
	public void setUp() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public void testCalculate_EmptyStringGiven_ShouldReturnZero() throws Exception {
		int result = stringCalculator.calculate("");
		assertEquals(0, result);
	}
	
	@Test
	public void testCalculate_AnySingleValueGiven_ShouldReturnSameNumber() throws Exception {
		int result = stringCalculator.calculate(ANY_SINGLE_VALUE_AS_STRING);
		assertEquals(5,result);
	}
	
	@Test
	public void testCalculate_TwoValuesGivenSeperatedByCommaAs10And20_ShouldReturn30() throws Exception {
		int result = stringCalculator.calculate("10,20");
		assertEquals(30,result);
	}
	
	@Test
	public void testCalculate_ThreeValuesGivenSeparatedByCommaAs1_2And3_ShouldReturn6() throws Exception {
		int result =stringCalculator.calculate("1,2,3");
		assertEquals(6,result);
		
	}
	
	
	
}
