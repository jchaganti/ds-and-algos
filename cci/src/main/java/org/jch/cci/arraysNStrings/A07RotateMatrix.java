package org.jch.cci.arraysNStrings;

import com.google.common.primitives.Ints;

public class A07RotateMatrix {
	
	private void rotate(int[][] input) {
		if(input != null && input.length == input[0].length) {
			int layers = (int)Math.ceil(input.length/2);
			int layerElems = input.length - 1;
			for(int layer = 0; layer < layers; layer++) {
				int [] cachedTop = new int[layerElems];
				for(int k = 0; k < layerElems; k++) {
					cachedTop[k] = input[layer][layer + k];
				}
				moveLeftToTop(input, layer);
				moveBottomToLeft(input, layer);
				moveRightToBottom(input, layer);
				moveTopToRight(input, layer, cachedTop);
				layerElems -= 2;
			}
		}
	}
	
	private void moveTopToRight(int[][] input, int layer, int[] cachedTop) {
		int start = input.length - 1 - layer;
		int end = layer;
		int cacheLen = cachedTop.length - 1;
		System.out.println("CachedTop: " + Ints.join(",", cachedTop));
		System.out.println("Diff: " + (start - end) + " Start: " + start + " End: " + end);
		
		input[start][start] = input[layer][start];
		
		for(int i = start; i> end; i--) {
			System.out.println("cacheLen: " + cacheLen);
			input[i - 1][start] = cachedTop[cacheLen];
			cacheLen--;
			
		}
	}

	private void moveRightToBottom(int[][] input, int layer) {
		int start = input.length - 1 - layer;
		int end = layer;
		
		for(int i = start; i> end; i--) {
			input[start][start - i + layer] = input[i][start - layer];
		}
	}

	private void moveBottomToLeft(int[][] input, int layer) {
		int start = input.length - 1 - layer;
		int end = layer;
		
		for(int i = start; i> end; i--) {
			input[i][layer] = input[start][i];
		}
	}

	private void moveLeftToTop(int[][] input, int layer) {
		int start = input.length - 1 - layer;
		int end = layer;
		
		for(int i = start; i> end; i--) {
			input[layer][start - i + layer] = input[i][layer];
		}		
	}

	public static void main(String[] args) {
		int[][] input5 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,0,14,15},
				{15,16,17,18,19},
				{20,21,22,23,24}
		};
		int[][] input6 = {
				{1, 2, 3, 4, 5,6},
				{6, 7, 8, 9, 10,11},
				{11,12,0,14,15,16},
				{15,16,17,18,19,20},
				{20,21,22,23,24,25},
				{26,27,28,29,30,31}
		};
		
		A07RotateMatrix a07 = new A07RotateMatrix();
		int[][] input = input5;
		a07.rotate(input);
		for(int i = 0; i < input.length; i++) {
			System.out.println(Ints.join(",", input[i]));
		}
		
	}
}
