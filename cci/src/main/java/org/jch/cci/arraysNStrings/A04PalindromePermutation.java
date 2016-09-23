package org.jch.cci.arraysNStrings;

import com.google.common.base.Strings;

public class A04PalindromePermutation {

	private boolean isPalindromePermutation(String input) {
		if(!Strings.isNullOrEmpty(input)) {
			boolean [] flags = new boolean[128];
			char [] chars = input.toCharArray();
			for(char c: chars) {
				flags[c] = !flags[c];
			}
			boolean oddCharFound = false;
			for(boolean b: flags) {
				if(b) {
					if(!oddCharFound) {
						oddCharFound = true;
					}
					else {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean isPalindromePermutationUsingBitVector(String input) {
		if(!Strings.isNullOrEmpty(input)) {
			int val = 0;
			char [] chars = input.toCharArray();
			for(char c: chars) {
				val = toggleBit(val, (int)c);
			}
			// Check if only 1 bit is set to 1
			return val == 0 || (val &  (val - 1)) == 0;
		}
		return false;
	}
	
	
	private int toggleBit(int val, int c) {
		int mask = 1 << c;
		if((val & mask) == 0) {
			val |= mask;
		}
		else {
			val &= ~mask;
		}
		return val;
	}

	public static void main(String[] args) {
		String input = "malayalamw";
		A04PalindromePermutation a04 = new A04PalindromePermutation();
		boolean res = a04.isPalindromePermutation(input);
		System.out.println("Res0: " + res);
		res = a04.isPalindromePermutationUsingBitVector(input);
		System.out.println("Res1: " + res);
	}

}
