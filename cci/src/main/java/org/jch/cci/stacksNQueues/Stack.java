package org.jch.cci.stacksNQueues;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	private List<T> list;
	private boolean validInteger;
	private java.util.Stack<Integer> mins;
	
	public  Stack() {
		list = new ArrayList<T> ();
	}
	
	public void push(T t) throws Exception {
		if(t instanceof Integer) {
			validInteger = true;
			Integer n = (Integer)t;
			if(list.size() == 0) {
				mins = new java.util.Stack<Integer>();
				mins.push(n.intValue());
			}
			else {
				int topMin = mins.peek();
				mins.push(Math.min(n.intValue(), topMin));
			}			
		}
		list.add(t);
	}
	
	public T pop() throws Exception {
		int size = list.size();
		if(size == 0) {
			throw new Exception("Stack is empty");
		}
		if(mins != null) {
			mins.pop();
		}
		
		T t = list.get(size - 1);
		list.remove(size - 1);
		return t;
	}
	
	public int size() {
		return list.size();
	}
	
	public T peek() throws Exception {
		int size = list.size();
		if(size == 0) {
			throw new Exception("Stack is empty");
		}
		T t = list.get(size - 1);
		return t;
	}
	
	public int min() throws Exception {
		if(list.size() >0 && validInteger) {
			return mins.pop();
		}
		else {
			throw new Exception("Invalid op!");
		}
	}

	@Override
	public String toString() {
		return "Stack [list=" + list + "]";
	}

}
