package org.jch.cci.linkedLists;

import java.util.Random;

public class A04Partition {
	
	private LinkedList<Integer> partition(LinkedList<Integer> in, int x) {
		LinkedList<Integer> out = new LinkedList<Integer>();
		out.insert(x);
		LinkedListNode<Integer> head = out.get(0);
		LinkedListNode<Integer> tail = out.get(0);
		LinkedListNode<Integer> node = in.get(0);
		while(node != null) {
			Integer data = node.data;
			if(data.intValue() < x) {
				head = out.insertBefore(head, data);
			}
			else if(data.intValue() > x) {
				tail = out.insertAfter(tail, data);
			}
			node = node.next;
		}
		out.head(head);
		return out;
	
	}

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Random r = new Random();
		for (int i = 1; i < 5; i++) {
			ll.insert(r.nextInt(2000));
		}
		LinkedListNode<Integer> linkedListNode = ll.get(2);
		System.out.println("Partition elem: " + linkedListNode.data);
		System.out.println("Before: " + ll);
		A04Partition a04 = new A04Partition();
		ll = a04.partition(ll, linkedListNode.data);
		System.out.println("After : " + ll);
	}

}
