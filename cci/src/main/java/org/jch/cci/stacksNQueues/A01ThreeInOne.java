package org.jch.cci.stacksNQueues;

public class A01ThreeInOne {

	public static void main(String[] args) {
		FixedMultiStack<Integer> stack = new FixedMultiStack(3, 10);
		
		try {
			for(int i = 0; i < 30; i++) {
				stack.push(i%3, i);
			}
			
			System.out.println("Before pop: " + stack.toString());
			
			System.out.println("Popping from stack 1: " + stack.pop(0));
			System.out.println("Popping from stack 2: " + stack.pop(1));
			System.out.println("Popping from stack 3: " + stack.pop(2));

			System.out.println("After pop: " + stack.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@SuppressWarnings("unchecked")
	private static class FixedMultiStack<T> {
		private T [] values;
		private int [] sizes;
		private int numberOfStacks;
		private int stackSize;
		
		
		public FixedMultiStack(int numberOfStacks, int stackSize) {
			this.numberOfStacks = numberOfStacks;
			this.stackSize = stackSize;
			sizes = new int [numberOfStacks];
			values = (T[]) new Object [stackSize * numberOfStacks];
		}
		
		public void push(int stackNum, T elem) throws Exception{
			if(isFull(stackNum)) {
				throw new Exception("Stack is full");
			}
			int index = indexOnTop(stackNum);
			values[index] = elem;
			sizes[stackNum]++;
		}
		
		public T pop(int stackNum) throws Exception{
			if(isEmpty(stackNum)) {
				throw new Exception("Stack is empty");
			}
			int index = indexOnTop(stackNum) - 1;
			sizes[stackNum]--;
			T val = values[index];
			values[index] = null;
			return val;
		}
		
		public T peek(int stackNum) throws Exception{
			if(isEmpty(stackNum)) {
				throw new Exception("Stack is empty");
			}
			int index = indexOnTop(stackNum) - 1;
			return values[index];
		}
		
		private int indexOnTop(int stackNum) {
			int top = (stackNum * stackSize) + sizes[stackNum];
			return top;
		}

		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackSize;
		}
		
		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			int stackNum = 1;
			for(int i = 0; i < stackSize * numberOfStacks; i++) {
				if(i % stackSize == 0) {
					sb.append("\n");
					sb.append("******************");
					sb.append("\n");
					sb.append("Stack #: " + stackNum++);
					sb.append("\n");
				}
				sb.append(values[i] + ",");
			}
			return sb.toString();
		}
	}

}
