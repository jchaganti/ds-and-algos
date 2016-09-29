package org.jch.cci.linkedLists;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class A08Loop {
	
	private LinkedListNode<Integer> detectLoop(LinkedListNode<Integer> node) {
		LinkedListNode<Integer> slow = node;
		LinkedListNode<Integer> fast = node;
		int k = 0;
		while (fast != null) {
			fast = fast.next;
			k++;
			slow = slow.next;
			if(fast != null) {
				fast = fast.next;
			}
			else {
				return null;
			}
			if(slow == fast) {
				break; // Loop found
			}
		}
		
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		return fast;
	}
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		l1.insert(1);
		LinkedListNode<Integer> head = l1.get(0);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		l1.insert(8);
		l1.insert(9);
		l1.insert(10);
		l1.insert(11);
		l1.insert(12);
		
		LinkedListNode<Integer> loopNode = l1.get(6);
		System.out.println("Loop Node: " + loopNode.data);
		LinkedListNode<Integer> node = l1.get(11);
		System.out.println("Last Node: " + node.data);
		node.next = loopNode;
		//System.out.println("L1: " + l1);
		A08Loop a08 = new A08Loop();
		LinkedListNode<Integer> loopHead = a08.detectLoop(head);
		System.out.println("Loop Head: " + loopHead.data);
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
