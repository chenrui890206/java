package com.ray.leetcode;

import java.util.HashSet;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have. Each character in S is a type of stone you have. You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

*/
public class Problem_0771_JewelsandStones {
	
	public int numJewelsInStones(String J, String S) {
		int result = 0;
		if (J == null || "".equals(J) || S == null || "".equals(S)) {
			return result;
		}
		HashSet<Character> set = new HashSet<>();
		for (char j : J.toCharArray()) {
			set.add(j);
		}
		for (char s : S.toCharArray()) {
			if (set.contains(s)) {
				result++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem_0771_JewelsandStones solution = new Problem_0771_JewelsandStones();
		System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
	}
}
