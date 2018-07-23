package com.yash.primefactor_tdd_demo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeFactorTest {

	@Test
	public void testCalculateFor_OneGiven_ShouldReturnEmpty() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(1);
		assertEquals(Arrays.asList(), factors);
	}
	
	@Test
	public void testCalculateFactorFor_TwoGiven_ShouldReturnTwoAsFactor() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(2);
		assertEquals(Arrays.asList(2), factors);
		
	}
	
	@Test
	public void testCalculateFactorFor_ThreeGiven_ShouldReturnThreeAsFactor() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(3);
		assertEquals(Arrays.asList(3), factors);
	}
	
	@Test
	public void testCalculateFactorFor_FourGiven_ShouldReturnTwoAndTwoAsFactors() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(4);
		assertEquals(Arrays.asList(2,2), factors);
	}
	
	@Test
	public void testCalculateFactorFor_FiveGiven_ShouldReturnFiveAsFactor() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(5);
		assertEquals(Arrays.asList(5), factors);
	}
	
	@Test
	public void testCalculateFactorFor_SixGiven_ShouldReturnThreeAndTwoAsFactors() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(6);
		assertEquals(Arrays.asList(2,3), factors);
	}
	
	@Test
	public void testCalculateFactorFor_SevenGiven_ShouldReturnSevenAsFactor() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(7);
		assertEquals(Arrays.asList(7), factors);
	}
	
	@Test
	public void testCalculateFactorFor_EightGiven_ShouldReturnTwo_TwoAndTwoAsFactors() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(8);
		assertEquals(Arrays.asList(2,2,2), factors);
	}
	
	@Test
	public void testCalculateFactorFor_NineGiven_ShouldReturnThreeAndThreeAsFactors() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(9);
		assertEquals(Arrays.asList(3,3), factors);
	}
	
	@Test
	public void testCalculateFactorFor_TenGiven_ShouldReturnFiveAndTwoAsFactors() throws Exception {
		List<Integer> factors = PrimeFactor.calculateFor(10);
		assertEquals(Arrays.asList(2,5), factors);
	}
}
