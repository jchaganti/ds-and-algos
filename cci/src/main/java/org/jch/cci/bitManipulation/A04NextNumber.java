package org.jch.cci.bitManipulation;

public class A04NextNumber {
	
	private int nextNumber(int num) {
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		while((c & 1) == 0 && c != 0) {
			c0++;
			c = c >> 1;
		}
		
		while((c & 1) == 1) {
			c1++;
			c = c >> 1;
		}
		
		int p = c0 + c1;
		
		if(p == 32 || p == 0) {
			return -1;
		}
		else {
			int mask = 1 << p;
			// Toggle 0 to 1
			num |= mask;
			mask = mask - 1;
			mask = ~mask; // All 1s followed by p 0s
			num = num & mask;
			mask = 1 << (c1 -1); 
			mask = mask - 1; // Mask with trailing (c1 - 1) 1s
			num |= mask;
			return num;
		}		
	}
	
	private int prevNumber(int num) {
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		while((c & 1) == 1 && c != 0) {
			c1++;
			c = c >> 1;
		}
		
		while((c & 1) == 0 && c != 0) {
			c0++;
			c = c >> 1;
		}
		
		int p = c0 + c1;
		
		if(p == 32 || p == 0) {
			return -1;
		}
		else {
			int mask = (~0) << (p + 1);
			num &= mask; // Clear off p 0s
			mask = 1 << (c1 + 1); 
			mask = (mask - 1) << (c0 - 1);
			num |= mask;
			return num;
		}	
	}

	public static void main(String[] args) {
		//011011001111100
		//011011010001111
		A04NextNumber a04 = new A04NextNumber();
		int num = Integer.parseInt("011011001111100", 2);
		System.out.println("Num: " + num);
		int next = a04.nextNumber(num);
		System.out.println("Next Num: " + next);
		
		num = Integer.parseInt("10011110000011", 2);
		System.out.println("Num: " + num);
		int prev = a04.prevNumber(num);
		System.out.println("Prev Num: " + prev);
	}

}
