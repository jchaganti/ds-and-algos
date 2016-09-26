package org.jch.cci.linkedLists;

import java.util.Random;

public class A05SumLists {
	
	private void sumLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2, LinkedList<Integer> l, int carry) {
		if(l1 == null && l2 == null) {
			if(carry > 0) {
				l.insert(carry);
			}
			return;
		}
		
		//System.out.println("L1: " + l1 + " L2:" + l2);
		int sum = 0;
		if(l1 != null) {
			sum += l1.data;
		}
		
		if(l2 != null) {
			sum += l2.data;
		}
		
		sum += carry;
		l.insert(sum % 10);
		
		sumLists(l1 != null? l1.next: null, l2 != null? l2.next: null, l, sum/10);
	}

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		Random r = new Random();
		int n = 10;
		for (int i = 1; i < n; i++) {
			int k = r.nextInt(10);
			if(i == n - 1 && k == 0) {
				continue;
			}
			l1.insert(k);
			
		}

		LinkedList<Integer> l2 = new LinkedList<Integer>();
		for (int i = 1; i < n; i++) {
			int k = r.nextInt(10);
			if(i == n - 1 && k == 0) {
				continue;
			}
			l2.insert(k);
		}
		System.out.println("L1: " + l1);
		System.out.println("L2: " + l2);
		LinkedList<Integer> res = new LinkedList<Integer>();
		A05SumLists a05 = new A05SumLists();
		a05.sumLists(l1.get(0), l2.get(0), res, 0);
		
		
		System.out.println("Res: " + res);
	}

}
