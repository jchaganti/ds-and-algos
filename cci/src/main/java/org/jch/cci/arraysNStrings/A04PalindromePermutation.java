package org.jch.cci.arraysNStrings;

import java.util.Arrays;

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
	public static void main(String[] args) {
		String input = "abcdabcdea";
		A04PalindromePermutation a04 = new A04PalindromePermutation();
		boolean res = a04.isPalindromePermutation(input);
		System.out.println("Res: " + res);

	}

}
