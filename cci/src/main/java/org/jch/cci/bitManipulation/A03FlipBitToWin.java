package org.jch.cci.bitManipulation;

public class A03FlipBitToWin {

	private int flipBit(int num) {
		int maxLength = 1;
		int prevLength = 1;
		int curLength = 1;
		int j = 0;
		while(j < 32) {
			int mask = 1 << j;
			if((num & mask) > 0) {
				curLength++;
				if((prevLength + curLength) > maxLength) {
					maxLength = prevLength + curLength;
				}
			}
			else {
				prevLength = curLength;
				curLength = 0;
			}
			j++;
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		A03FlipBitToWin a03 = new A03FlipBitToWin();
		int res = a03.flipBit(Integer.parseInt("011011111111", 2));
		System.out.println("Res: " + res);
	}

}
