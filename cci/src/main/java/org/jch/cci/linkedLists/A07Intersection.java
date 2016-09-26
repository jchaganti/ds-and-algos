package org.jch.cci.linkedLists;

public class A07Intersection {
	
	private LinkedListNode<Integer> findIntersection(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		Data d1 = getLengthAndTail(l1.get(0));
		Data d2 = getLengthAndTail(l2.get(0));
		
		if(d1.tail == d2.tail) {
			int diff = d1.len - d2.len;
			LinkedListNode<Integer> node1 = l1.get(0);
			LinkedListNode<Integer> node2 = l2.get(0);
			if(diff < 0) {
				diff = Math.abs(diff);
				while(diff > 0) {
					node2 = node2.next;
					diff--;
				}
			}
			else if(diff > 0) {
				while(diff > 0) {
					node1 = node1.next;
					diff--;
				}
			}
			
			while(node1 != null && node2 != null) {
				if(node1 == node2){
					return node1;
				}
				node1 = node1.next;
				node2 = node2.next;
			}
		}
		
		return null;
	}

	private Data getLengthAndTail(LinkedListNode<Integer> node) {
		int len = 0;
		while(node != null) {
			len++;
			node = node.next; 
		}
		
		Data d = new Data();
		d.len = len;
		d.tail = node;
		return d;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		
		LinkedListNode<Integer> common = l1.get(3);
		
		LinkedList<Integer> l2 = new LinkedList<Integer> ();
		l2.insert(9);
		l2.insert(10);
		l2.insert(11);
		l2.insert(12);
		l2.insert(13);
		
		l2.get(4).next = common;
		
		LinkedList<Integer> l3 = new LinkedList<Integer> ();
		l3.insert(20);
		l3.insert(21);
		l3.insert(22);
		l3.insert(23);
		l3.insert(24);
	
		System.out.println("L1: " + l1);
		System.out.println("L2: " + l2);
		
		A07Intersection a07 = new A07Intersection();
		common = a07.findIntersection(l2, l1);
		if(common != null) {
			System.out.println("Common: " + common.data);
		}
		else {
			System.out.println("Common: null");
		}
		
		
	}
	
	private static class Data {
		public int len;
		public LinkedListNode<Integer> tail;
	}
}


