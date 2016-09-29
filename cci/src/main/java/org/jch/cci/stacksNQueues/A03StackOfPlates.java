package org.jch.cci.stacksNQueues;

public class A03StackOfPlates {

	public static void main(String[] args) {
		try {
			StackofStacks<Integer> stack = new StackofStacks<Integer>();
			for(int i = 0; i < 35; i++) {
				stack.push(i);
			}
			System.out.println("Before pop the stack: " + stack);
			
			for(int i = 0; i < 12; i++) {
				stack.pop();
			}
			
			System.out.println("After pop the stack: " + stack);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static class StackofStacks<T> {
		private Stack<Stack<T>> stackOfStacks;
		private Stack<T> curStack;
		private int maxSize = 10;
		
		public StackofStacks() throws Exception {
			stackOfStacks = new Stack<Stack<T>>();
		}
		
		public void push(T t) throws Exception {
			if(stackOfStacks.size() == 0) {
				curStack = new Stack<T> ();
				stackOfStacks.push(curStack);
			}
			if(curStack.size() == maxSize) {
				curStack = new Stack<T> ();
				stackOfStacks.push(curStack);
			}
			curStack.push(t);
		}
		
		public T pop() throws Exception {
			if(stackOfStacks.size() == 0) {
				throw new Exception("Stack of stacks is empty");
			}
			if(curStack.size() == 0) {
				curStack = stackOfStacks.pop();
				if(curStack.size() == 0) {
					curStack = stackOfStacks.peek();
				}
			}
			return curStack.pop();		
		}
		
		public String toString() {
			return stackOfStacks.toString();
		}
	}

}
