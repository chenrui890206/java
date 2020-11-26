package com.ray.leetcode;

import java.util.Arrays;

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
(3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

*/
public class Problem_0164_MaximumGap {
	
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(nums[i] - nums[i - 1], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Problem_0164_MaximumGap solution = new Problem_0164_MaximumGap();
		int[] arr = {3, 6, 9, 1};
		System.out.println(solution.maximumGap(arr));
	}
}
