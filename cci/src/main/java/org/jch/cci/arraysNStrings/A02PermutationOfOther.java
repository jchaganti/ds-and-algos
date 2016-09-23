package org.jch.cci.arraysNStrings;

import java.util.Arrays;

import com.google.common.base.Strings;

public class A02PermutationOfOther {
	
	private boolean isPermutation(String s1, String s2) {
		if(!Strings.isNullOrEmpty(s1) && !Strings.isNullOrEmpty(s2) && s1.length() == s2.length()) {
			char [] s1Chars = s1.toCharArray();
			Arrays.sort(s1Chars);
			String s1Sorted = new String(s1Chars);
			
			char [] s2Chars = s2.toCharArray();
			Arrays.sort(s2Chars);
			String s2Sorted = new String(s2Chars);
			
			return s1Sorted.equals(s2Sorted);			
		}
		return false;
	}
	
	private boolean isPermutationOpt(String s1, String s2) {
		if(!Strings.isNullOrEmpty(s1) && !Strings.isNullOrEmpty(s2) && s1.length() == s2.length()) {
			int [] letters = new int[128];			
			char [] chars = s1.toCharArray();
			for(char c: chars) {
				letters[c]++;
			}
			chars = s2.toCharArray();
			for(char c: chars) {
				letters[c]--;
				if(letters[c] < 0) {
					System.out.println("Char: " + (char)c);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s2 = "primeminister";
		String s1 = "retsinimripem";
		A02PermutationOfOther perm = new A02PermutationOfOther();
		boolean res = perm.isPermutationOpt(s1, s2);
		System.out.println("Res0: " + res);

	}

}
