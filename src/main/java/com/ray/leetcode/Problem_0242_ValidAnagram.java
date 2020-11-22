package com.ray.leetcode;

/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

*/
public class Problem_0242_ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] ints = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ints[s.charAt(i)-'a']++;
			ints[t.charAt(i)-'a']--;
		}
		
		for (int i : ints) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem_0242_ValidAnagram solution = new Problem_0242_ValidAnagram();
		System.out.println(solution.isAnagram("anagram", "nagaram"));
		
	}
}
