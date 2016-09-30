package org.jch.cci.stacksNQueues;

import java.util.Random;

public class A05SortStack {

	private void sort(Stack<Integer> in) {
		Stack<Integer> buffer = new Stack<Integer>();
		try {
			while(in.size() > 0) {
				if(buffer.size() == 0) {
					buffer.push(in.pop());
				}
				else {
					int temp = in.pop();
					if(temp < buffer.peek()) {
						int out = buffer.peek();
						int inPushes = 0;
						while(temp < out) {
							in.push(buffer.pop());
							inPushes++;
							if(buffer.size() > 0) {
								out = buffer.peek();
							}
							else {
								break;
							}
						}
						buffer.push(temp);
						
						while(inPushes > 0) {
							buffer.push(in.pop());
							inPushes--;
						}
					}
					else {
						buffer.push(temp);
					}
				}
			}
			
			while(buffer.size() > 0) {
				in.push(buffer.pop());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		Random r = new Random();
		try {
			for(int i = 0; i < 10; i++) {
				stack.push(r.nextInt(1000));
			}
			System.out.println("Before: " + stack);
			
			A05SortStack a05 = new A05SortStack();
			a05.sort(stack);
			System.out.println("After: " + stack);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
