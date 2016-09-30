package org.jch.cci.bitManipulation;

public class A01Insertion {

	private int insert(int m, int n, int i, int j) {
		int mask = (1 << i) - 1;
		System.out.println("mask: " + Integer.toBinaryString(mask));
		mask = ((~0 << (j+1)) | mask);
		System.out.println("mask: " + Integer.toBinaryString(mask));
		m =  m << i;
		return (mask & n) | m;		
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt("10000000000", 2);
		int m = Integer.parseInt("10011", 2);
		int i = 2;
		int j = 6;
		A01Insertion a01 = new A01Insertion();
		int res = a01.insert(m, n, i, j);
		System.out.println("res: "+ Integer.toBinaryString(res));

	}

}
