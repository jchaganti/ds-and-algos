package org.jch.cci.linkedLists;


public class A03DeleteMiddleNode {
	
	private void delete(LinkedListNode<Integer> node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 1; i < 21; i++) {
			ll.insert(i);
		}
		System.out.println("Before: " + ll);
		A03DeleteMiddleNode a03 = new A03DeleteMiddleNode();
		a03.delete(ll.get(5));
		a03.delete(ll.get(10));
		System.out.println("After : " + ll);
	}
	
	

}
