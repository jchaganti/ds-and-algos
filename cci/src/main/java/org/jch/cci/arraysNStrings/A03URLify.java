package org.jch.cci.arraysNStrings;

import java.util.Arrays;

public class A03URLify {
	
	private void encode(char [] input, int len) {
		if(input != null && len > 0) {
			// "Mr John Smith    "
			// "Mr%20John%20Smith"
			int cLen = input.length;
			int iLen = len - 1;
			for(int i = cLen - 1; i>=0;) {
				if(input[iLen] == ' ') {
					input[i--] = '0';
					input[i--] = '2';
					input[i--] = '%';
				}
				else {
					input[i--] = input[iLen];
				}
				iLen--;
			}
		}
	}

	public static void main(String[] args) {
		String s = "Mr John Smith";
		int whiteSpaces = 2;
		char [] chars = Arrays.copyOf(s.toCharArray(), s.length() + (whiteSpaces * 2));
		A03URLify urlifier = new A03URLify();
		System.out.println("Ori: " + new String(chars));
		urlifier.encode(chars, s.length());
		System.out.println("Res: " + new String(chars));
		
	}

}
