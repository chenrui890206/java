package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;


/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

* */
public class Problem_0078_Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(0, nums, res, new ArrayList<>());
		return res;
		
	}
	
	private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
		res.add(new ArrayList<>(tmp));
		for (int j = i; j < nums.length; j++) {
			tmp.add(nums[j]);
			backtrack(j + 1, nums, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Problem_0078_Subsets solution = new Problem_0078_Subsets();
		System.out.println(solution.subsets(arr));
	}
	
}
