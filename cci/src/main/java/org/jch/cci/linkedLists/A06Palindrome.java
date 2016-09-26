package org.jch.cci.linkedLists;

import java.util.Stack;

public class A06Palindrome {

	private boolean isPalindrome(LinkedListNode<Integer> node, int size) {
		if(size == 1) {
			return true;
		}
		Stack<LinkedListNode<Integer>> stack = new Stack<LinkedListNode<Integer>>();
		int k = 0;
		while(k < size/2) {
			stack.push(node);
			k++;
			node = node.next;
		}
		System.out.println("Stack size: " + stack.size());
		if(size % 2 == 1) {
			node = node.next;
		}
		
		while(node != null) {
			if(!stack.isEmpty() && node != null) {
				LinkedListNode<Integer> left = stack.pop();
				LinkedListNode<Integer> right = node;
				System.out.println("left: " + left.data + " Right: " + right.data);
				if(!left.data.equals(right.data)) {
					return false;
				}
				node = node.next;
			}
			else {
				break;
			}
			
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer> ();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(9);
		l.insert(4);
		l.insert(3);
		l.insert(2);
		l.insert(1);
		A06Palindrome a06 = new A06Palindrome();
		boolean res = a06.isPalindrome(l.get(0), 9);
		System.out.println("Res: " + res);
	}

}
