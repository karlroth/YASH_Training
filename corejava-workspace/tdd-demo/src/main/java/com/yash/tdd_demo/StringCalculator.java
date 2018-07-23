package com.yash.tdd_demo;

import java.util.Arrays;

public class StringCalculator {

	public int calculate(String value) {
		if(value.isEmpty()) {
			return 0;
		} 
		
		else {
			return Arrays.stream(value.split(",")).mapToInt(Integer::parseInt).sum();
		}
	}
}
