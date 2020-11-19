package com.ray.leetcode;

import java.util.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
public class Problem_0283_MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		if (nums == null) {
			return;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, index);
				index++;
			}
		}
	}
	
	public void swap(int[] num, int left, int right) {
		int tmp = num[right];
		num[right] = num[left];
		num[left] =  tmp;
	}
	
	public static void main(String[] args) {
		Problem_0283_MoveZeroes solution = new Problem_0283_MoveZeroes();
		int[] nums = {0, 1, 0, 3, 12};
		solution.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
