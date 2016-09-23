package org.jch.cci.arraysNStrings;

import com.google.common.base.Strings;

public class A06StringCompression {

	private String compress(String str) {
		if(!Strings.isNullOrEmpty(str)) {
			char [] chars = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			int curCount = 1;
			char curChar = '\0';
			for(int i = 0; i < chars.length;) {
				curChar = chars[i];
				while(i < chars.length - 1 && chars[i] == chars[i+1]) {
					curCount++;
					i++;
				}
				i++;
				sb.append(curChar).append(curCount);
				curCount = 1;
			}
			return sb.toString();
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "acccccccccccc";
		A06StringCompression a06 = new A06StringCompression();
		String compressedStr = a06.compress(str);
		System.out.println("Res: " + compressedStr);
		if(compressedStr.length() > str.length()) {
			compressedStr = str;
		}
		System.out.println("Res: " + compressedStr);
	}

}
