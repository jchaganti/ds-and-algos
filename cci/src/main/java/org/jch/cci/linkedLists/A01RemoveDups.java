package org.jch.cci.linkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class A01RemoveDups {

	private <T> void removeDups(LinkedList<T> ll) {
		Set<T> set = new HashSet<T> ();
		Iterator<T> it = ll.iterator();
		while(it.hasNext()) {
			T t = it.next();
			if(set.contains(t)) {
				it.remove();
			}
			else {
				set.add(t);
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 1; i < 21; i++) {
			ll.add(i % 10);
		}
		System.out.println("Before: " + ll);
		A01RemoveDups a01 = new A01RemoveDups();
		a01.removeDups(ll);
		System.out.println("After:  " + ll);
	}

}
