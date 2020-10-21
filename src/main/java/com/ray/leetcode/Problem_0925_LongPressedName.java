package com.ray.leetcode;

/*
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.

*/
public class Problem_0925_LongPressedName {
	
	public boolean isLongPressedName(String name, String typed) {
		if (name == null || typed == null || name.length() > typed.length()) {
			return false;
		}
		int x = 0;
		int y = 0;
		boolean flag = false;
		for (char c : name.toCharArray()) {
			while (y < typed.length() && c == typed.charAt(y)) {
				y++;
				flag = true;
			}
			x++;
			if (! flag || (x < name.length() - 1 && y == typed.length() - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem_0925_LongPressedName solution = new Problem_0925_LongPressedName();
		System.out.println(solution.isLongPressedName("alex", "aaleex"));
//		System.out.println(solution.isLongPressedName("laiden", "laiden"));
//		System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
	}
}
