package com.ray.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

*/
public class Problem_0349_IntersectionofTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		Set<Integer> integers = new HashSet<>();
		for (int i : nums2) {
			if (set.contains(i)) {
				integers.add(i);
			}
		}
		int[] res = new int[integers.size()];
		int count = 0;
		for (Integer integer : integers) {
			res[count] = integer;
			count++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Problem_0349_IntersectionofTwoArrays solution = new Problem_0349_IntersectionofTwoArrays();
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
	}
}
