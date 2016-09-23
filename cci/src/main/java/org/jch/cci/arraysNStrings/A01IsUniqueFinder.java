package org.jch.cci.arraysNStrings;

import com.google.common.base.Strings;

public class A01IsUniqueFinder {
	
	private boolean isUnique(String str) {
		boolean unique = false;
		if(!Strings.isNullOrEmpty(str) && str.length() <= 128) {
			boolean [] flags = new boolean [128];
			char [] chars = str.toCharArray();
			for(char c: chars) {
				if(flags[c]) {
					return unique;
				}
				else {
					flags[c] = true;
				}
			}
			return true;
		}
		return unique;
	}
	
	private boolean isUniqueWOBoolArr(String str) {
		boolean unique = false;
		if(!Strings.isNullOrEmpty(str) && str.length() <= 26) {
			int val = 0;
			char [] chars = str.toCharArray();
			for(char c: chars) {
				int bitNum = c - 'a';
				if((val & (1 << bitNum)) > 0) {
					return unique;
				}
				else {
					val |= (1 << bitNum);
				}
			}
			return true;
		}
		return unique;
	}

	public static void main(String[] args) {
		String s = "elEphant";
		A01IsUniqueFinder uniqueFinder = new A01IsUniqueFinder();
		boolean res = uniqueFinder.isUnique(s);
		System.out.println("Res0: " + res);
		res = uniqueFinder.isUniqueWOBoolArr("edphant");
		System.out.println("Res1: " + res);
	}

}
