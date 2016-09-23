package org.jch.cci.arraysNStrings;

public class A05OneAway {
	
	private boolean isOneEditAway(String s1, String s2) {
		if(s1 != null && s2 != null && !s1.equals(s2)) {
			int diff = Math.abs(s1.length() - s2.length());
			if(diff == 1 || diff == 0) {
				if(diff == 0) {
					return isOneEditReplace(s1, s2);
				}
				else {
					if(s1.length() > s2.length()) {
						return isOneEditInsert(s1, s2);
					}
					else {
						return isOneEditInsert(s2, s1);
					}
				}
			}
		}
		
		return false;
	}

	private boolean isOneEditReplace(String s1, String s2) {
		boolean foundExactlyOne = false;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundExactlyOne) {
					return false;
				}
				else {
					foundExactlyOne = true;
				}
			}
		}
		return true;
	}
	
	private boolean isOneEditInsert(String s1, String s2) {
		boolean foundExactlyOne = false;
		for(int i = 0,j = 0; i < s1.length();) {
			if(s1.charAt(i) != s2.charAt(j)) {
				if(foundExactlyOne) {
					return false;
				}
				else {
					foundExactlyOne = true;
					i++;
				}
			}
			else {
				i++;j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "bab";
		A05OneAway a05 = new A05OneAway();
		boolean res = a05.isOneEditAway(s1, s2);
		System.out.println("Res0: " + res);

	}

}
