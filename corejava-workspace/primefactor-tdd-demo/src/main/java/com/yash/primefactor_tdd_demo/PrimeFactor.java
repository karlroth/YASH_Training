package com.yash.primefactor_tdd_demo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PrimeFactor {

	public static List<Integer> calculateFor(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int candidate = 2;
		while (n > 1) {
			while (n % candidate == 0) {
				factors.add(candidate);
				n /= candidate;
			}
			candidate++;
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

}
