package org.jch.cci.arraysNStrings;

import com.google.common.base.Strings;

public class A09StringRotation {

	private boolean isRotation(String s1, String s2) {
		if(!Strings.isNullOrEmpty(s1) && !Strings.isNullOrEmpty(s2) && s1.length() == s2.length()) {
			return (s1 + s1).contains(s2);
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		String s1 = "helloworld";
		String s2 = "oworldhell";
		A09StringRotation a09 = new A09StringRotation();
		boolean res = a09.isRotation(s1, s2);
		System.out.println("Res: " + res);
	}

}
