package com.ray.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

*/
public class Problem_0844_BackspaceStringCompare {
	
	public boolean backspaceCompare(String S, String T) {
		if (S == null || T == null) {
			return false;
		}
		Deque<Character> sstack = new ArrayDeque<>();
		Deque<Character> tstack = new ArrayDeque<>();
		for (char schar : S.toCharArray()) {
			if (schar != '#') {
				sstack.addLast(schar);
			} else {
				sstack.pollLast();
			}
		}
		for (char tchar : T.toCharArray()) {
			if (tchar != '#') {
				tstack.addLast(tchar);
			} else {
				tstack.pollLast();
			}
		}
		boolean result = true;
		if (sstack.size() != tstack.size()) {
			return false;
		}
		while (sstack.peek() != null && tstack.peek() != null) {
			if (sstack.pollLast() != tstack.pollLast()) {
				result = false;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Problem_0844_BackspaceStringCompare solution = new Problem_0844_BackspaceStringCompare();
		System.out.println(solution.backspaceCompare("bxj##tw", "bxj###tw"));
	}
}
