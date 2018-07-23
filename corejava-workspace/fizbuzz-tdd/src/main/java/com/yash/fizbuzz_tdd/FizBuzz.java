package com.yash.fizbuzz_tdd;

public class FizBuzz {

	public static String calculate(int i) {

		String answer = Integer.toString(i);
		checkNumber(i);
		answer = computeAnswer(i, answer); 
		
		return answer;
		
	}

	private static String computeAnswer(int i, String answer) {
		if (isDivisibleByThree(i) && isDivisibleByFive(i)) {
			answer = "FizBuzz";
		} else if (isDivisibleByThree(i)) {
			answer = "Fiz";
		} else if (isDivisibleByFive(i)) {
			answer = "Buzz";
		}
		return answer;
	}

	private static void checkNumber(int i) {
		if (i <= 0) {
			throw new IllegalArgumentException("Input must be greater than 0");
		}
	}

	private static boolean isDivisibleByFive(int i) {
		return i % 5 == 0;
	}

	private static boolean isDivisibleByThree(int i) {
		return i % 3 == 0;
	}

}
