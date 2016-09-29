package org.jch.cci.stacksNQueues;

public class A04QueueUsingStacks {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		
		try {
			for(int i = 0; i < 30; i++) {
				queue.add(i);
			}
			for(int i = 0; i < 30; i++) {
				int k = queue.remove();
				System.out.println(k);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static class MyQueue<T> {
		private Stack<T> oldest;
		private Stack<T> newest;
		
		private MyQueue() {
			oldest = new Stack<T>();
			newest = new Stack<T>();
		}
		
		private void add(T t) throws Exception {
			newest.push(t);
		}
		
		private int size() {
			return oldest.size() + newest.size();
		}
		
		private void shiftStacks() throws Exception {
			if(oldest.size() == 0) {
				while(newest.size() > 0) {
					oldest.push(newest.pop());
				}
			}
		}
		
		private T peek() throws Exception {
			shiftStacks();
			return oldest.peek();
		}
		
		private T remove() throws Exception {
			shiftStacks();
			return oldest.pop();
		}
	}

}
