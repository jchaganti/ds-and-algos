package org.jch.cci.bitManipulation;

public class A06Conversion {

	private int bitsToBeSwappedOpt(int a, int b) {
		int count = 0;
		
		for(int c = a^b; c != 0; c = (c & c - 1)) {
			count++;
		}
		return count;
	}
	
	private int bitsToBeSwapped(int a, int b) {
		int count = 0;
		
		for(int c = a^b; c != 0; c = c >> 1) {
			count = count + (c & 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		A06Conversion a06 = new A06Conversion();
		int a = 122; int b = 11;
		System.out.println(a + ": " + Integer.toBinaryString(a));
		System.out.println(b + ": " + Integer.toBinaryString(b));
		int res = a06.bitsToBeSwappedOpt(a, b);
		System.out.println("BitsToBeSwappedOpt: " + res);
		res = a06.bitsToBeSwapped(a, b);
		System.out.println("BitsToBeSwapped: " + res);
	}

}
