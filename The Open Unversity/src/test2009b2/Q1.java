package test2009b2;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		System.out.print("");
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.println(joker(in.nextLine(), in.nextLine()));
		}
	}

	public static boolean joker(String s1, String s2) {
		return joker(s1, s2, 0, 0, false, 0);
	}

	private static boolean joker(String s1, String s2, int i1, int i2, boolean joker, int iJ) {
		if (i1 == s1.length()) {
			return !joker;
		}
		if (i2 == s2.length()) {
			return false;
		}
		if (joker) {
			if (s1.charAt(i1) != s2.charAt(i2)) {
				return joker(s1, s2, i1 + 1, i2, true, iJ);
			} else if (joker(s1, s2, i1, i2, false, iJ)) {
				return true;
			} else {
				return joker(s1, s2, i1 + 1, i2, true, iJ);
			}
		} else {
			if (s2.charAt(i2) == '*') {
				return i2 == s2.length() - 1 || joker(s1, s2, i1, i2 + 1, true, i2);
			} else if (s1.charAt(i1) == s2.charAt(i2) && joker(s1, s2, i1 + 1, i2 + 1, false, iJ)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
