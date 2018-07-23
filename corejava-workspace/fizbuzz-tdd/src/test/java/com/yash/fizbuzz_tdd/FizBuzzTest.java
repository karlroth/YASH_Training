package com.yash.fizbuzz_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizBuzzTest {

	@Test
	public void testCalculateFor_OneGiven_ShouldReturnOneAsString() throws Exception {
		String result = FizBuzz.calculate(1);
		assertEquals("1", result);
	}
	
	@Test
	public void testCalculateFor_TwoGiven_ShouldReturnTwoAsString() throws Exception {
		String result = FizBuzz.calculate(2);
		assertEquals("2", result);
	}
	
	@Test
	public void testCalculateFor_ThreeGiven_ShouldReturnFizAsString() throws Exception {
		String result = FizBuzz.calculate(3);
		assertEquals("Fiz", result);
	}
	
	@Test
	public void testCalculateFor_FourGiven_ShouldReturnFourAsString() throws Exception {
		String result = FizBuzz.calculate(4);
		assertEquals("4", result);
	}
	
	@Test
	public void testCalculateFor_FiveGiven_ShouldReturnBuzzAsString() throws Exception {
		String result = FizBuzz.calculate(5);
		assertEquals("Buzz", result);
	}
	
	@Test
	public void testCalculateFor_SixGiven_ShouldReturnFizAsString() throws Exception {
		String result = FizBuzz.calculate(6);
		assertEquals("Fiz", result);
	}
	
	@Test
	public void testCalculateFor_SevenGiven_ShouldReturnSevenAsString() throws Exception {
		String result = FizBuzz.calculate(7);
		assertEquals("7", result);
	}
	
	@Test
	public void testCalculateFor_EightGiven_ShouldReturnEightAsString() throws Exception {
		String result = FizBuzz.calculate(8);
		assertEquals("8", result);
	}
	
	@Test
	public void testCalculateFor_NineGiven_ShouldReturnFizAsString() throws Exception {
		String result = FizBuzz.calculate(9);
		assertEquals("Fiz", result);
	}
	
	@Test
	public void testCalculateFor_TenGiven_ShouldReturnBuzzAsString() throws Exception {
		String result = FizBuzz.calculate(10);
		assertEquals("Buzz", result);
	}
	@Test
	public void testCalculateFor_ElevenGiven_ShouldReturnElevenAsString() throws Exception {
		String result = FizBuzz.calculate(11);
		assertEquals("11", result);
	}
	
	@Test
	public void testCalculateFor_TwelveGiven_ShouldReturnFizAsString() throws Exception {
		String result = FizBuzz.calculate(12);
		assertEquals("Fiz", result);
	}
	
	@Test
	public void testCalculateFor_FourteenGiven_ShouldReturnFourteenAsString() throws Exception {
		String result = FizBuzz.calculate(14);
		assertEquals("14", result);
	}
	
	@Test
	public void testCalculateFor_FifteenGiven_ShouldReturnFizBuzzAsString() throws Exception {
		String result = FizBuzz.calculate(15);
		assertEquals("FizBuzz", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateFor_ZeroGiven_ShouldReturnException() throws Exception {
		String result = FizBuzz.calculate(0);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateFor_NegativeOneGiven_ShouldReturnNegativeOneAsString() throws Exception {
		String result = FizBuzz.calculate(-1);
		
	}
	
	
	
}
