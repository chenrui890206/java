package com.ray.leetcode;

/*
Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

*/
public class Problem_0392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
            }
            j++;

        }
        return i == chars1.length;
    }

    public static void main(String[] args) {
        Problem_0392_IsSubsequence solution = new Problem_0392_IsSubsequence();
        System.out.println(solution.isSubsequence("", "aaabbbccc"));
    }
}
