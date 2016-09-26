package org.jch.cci.linkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
	private LinkedListNode<T> head;
	
	public void insert(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>();
		node.data = data;
		node.next = null;
		
		if(head == null) {
			head = node;
		}
		else {
			LinkedListNode<T> tail = head;
			while(tail.next != null) {
				tail = tail.next;
			}
			tail.next = node;
		}
	}
	
	public void head(LinkedListNode<T> head) {
		this.head = head;
	}
	
	public LinkedListNode<T> insertBefore(LinkedListNode<T> beforeNode, T data) {
		LinkedListNode<T> node = new LinkedListNode<T>();
		node.data = data;
		node.next = beforeNode;
		return node;
	}
	
	public LinkedListNode<T> insertAfter(LinkedListNode<T> afterNode, T data) {
		LinkedListNode<T> node = new LinkedListNode<T>();
		node.data = data;
		node.next = null;
		afterNode.next = node;
		return node;
	}
	
	public LinkedListNode<T> get(int i) {
		LinkedListNode<T> node = null;
		if(i >= 0) {
			int k = 0;
			LinkedListNode<T> tail = head;
			while(tail != null) {
				if(k == i) {
					node = tail;
					break;
				}
				else {
					k++;
					tail = tail.next;
				}
			}
		}
		return node;
	}
	
	public String toString() {
		List<T> l = new ArrayList<T> ();
		LinkedListNode<T> tail = head;
		l.add(tail.data);
		while(tail.next != null) {
			tail = tail.next;
			l.add(tail.data);
		}
		return l.toString();
	}

}
