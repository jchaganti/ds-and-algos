package org.jch.cci.bitManipulation;

public class A07PairWiseSwap {

	private int swapBits(int x) {
		return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
	}
	public static void main(String[] args) {
		int n1 = Integer.parseInt("1010111001111001", 2);
		A07PairWiseSwap a07 = new A07PairWiseSwap();
		int res = a07.swapBits(n1);
		System.out.println(Integer.toBinaryString(res));
	}

}
