package org.jch.cci.bitManipulation;

public class A05Debugger {

	public static void main(String[] args) {
		int n1 = Integer.parseInt("10000000000", 2);
		boolean powerOfTwo = ((n1) & (n1 - 1)) == 0;
		System.out.println("powerOfTwo: " + powerOfTwo);
		n1 = Integer.parseInt("11000000000", 2);
		powerOfTwo = ((n1) & (n1 - 1)) == 0;
		System.out.println("powerOfTwo: " + powerOfTwo);
	}

}
