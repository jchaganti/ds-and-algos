package org.jch.cci.arraysNStrings;

import com.google.common.primitives.Ints;

public class A08ZeroMatrix {

	private void zeroMatrix(int [][] input) {
		if(input != null) {
			boolean rowHasZero = false;
			boolean colHasZero = false;
			for(int col = 0; col < input[0].length; col++) {
				if(input[0][col] == 0) {
					rowHasZero = true;
					break;
				}
			}
			
			for(int row = 0; row < input.length; row++) {
				if(input[row][0] == 0) {
					colHasZero = true;
					break;
				}
			}
			
			for(int row = 1; row < input.length; row++) {
				for(int col = 1; col < input[0].length; col++) {
					if(input[row][col] == 0) {
						input[0][col] = 0;
						input[row][0] = 0;
					}
				}
			}
			for(int col = 1; col < input[0].length; col++) {
				if(input[0][col] == 0) {
					nullifyCol(input, col);
				}
			}
			
			for(int row = 1; row < input.length; row++) {
				if(input[row][0] == 0) {
					nullifyRow(input, row);
				}
			}
			
			if(rowHasZero) {
				for(int col = 0; col < input[0].length; col++) {
					 input[0][col] = 0;
				}
			}
			
			if(colHasZero) {
				for(int row = 0; row < input.length; row++) {
					 input[row][0] = 0;
				}
			}
		}
	}
	
	private void nullifyCol(int[][] input, int col) {
		for(int i = 0; i < input.length; i++) {
			input[i][col] = 0;
		}
	}
	
	private void nullifyRow(int[][] input, int row) {
		for(int i = 0; i < input[0].length; i++) {
			input[row][i] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] input = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,0,14,15},
				{15,16,17,18,19}
		};
		A08ZeroMatrix a08 = new A08ZeroMatrix();
		a08.zeroMatrix(input);
		for(int i = 0; i < input.length; i++) {
			System.out.println(Ints.join(",", input[i]));
		}
		
	}

}
