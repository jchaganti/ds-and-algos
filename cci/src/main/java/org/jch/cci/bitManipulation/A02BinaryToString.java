package org.jch.cci.bitManipulation;


// TODO - Incomplete
public class A02BinaryToString {

	private String printBinary(double num) {
		if(num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		double frac = 0.5;
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(num > 0) {
			if(sb.length() >= 32) {
				return "ERROR";
			}
			
			if(num >= frac) {
				sb.append(1);
				num -= frac;
			}
			else {
				sb.append(0);
			}
			
			frac = frac/2;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		
		A02BinaryToString a02 = new A02BinaryToString();
		String res = a02.printBinary(0.1);
		System.out.println("Res: " + res);
	}

}
