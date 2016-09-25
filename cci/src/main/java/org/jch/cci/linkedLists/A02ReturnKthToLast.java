package org.jch.cci.linkedLists;

import java.util.Iterator;
import java.util.LinkedList;

public class A02ReturnKthToLast {

	private <T> T kthToLast(Iterator<T> it, T cur, T prev, int k, Index idx) {
		if(cur == null) {
			return prev;
		}
		else {
			prev = cur;
			cur = it.hasNext()? it.next(): null;
			T t = kthToLast(it, cur, prev, k, idx);
			idx.value++;
			if(k == idx.value) {
				return prev;
			}
			return t;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		for(int i = 1; i < 21; i++) {
			ll.add(i);
		}
		
		System.out.println("LL:  " + ll);
		Iterator<Integer> it = ll.listIterator();
		Index idx = new Index();
		idx.value = 0;
		A02ReturnKthToLast a02 = new A02ReturnKthToLast();
		Integer i = a02.kthToLast(it, it.next(), null, 5, idx);
		System.out.println("Res: " + i);

	}
}

class Index {
	int value;
}
