package org.jch.cci.stacksNQueues;

import java.util.Random;

public class A02StackMin {

	public static void main(String [] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Random r = new Random();
		try {
			for(int i = 0; i < 10; i++) {
				stack.push(r.nextInt(1000));
			}
			
			System.out.println(stack);
			System.out.println("Min: " + stack.min());
			for(int i = 0; i < 3; i++) {
				int n = stack.pop();
				System.out.println("Popped: " + n);
				System.out.println("Min: " + stack.min());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
