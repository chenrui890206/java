package com.ray.leetcode;

import java.util.*;

/*
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.


Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

*/
public class Problem_1207_UniqueNumberofOccurrences {
	
	public boolean uniqueOccurrences(int[] arr) {
		if (arr == null) {
			return false;
		}
		Map<Integer,Integer> count = new HashMap<>();
		for (int i : arr) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for (Map.Entry<Integer,Integer> obj : count.entrySet()) {
			Integer key = obj.getKey();
			Integer value = obj.getValue();
			if (!set.add(value)) {
				return false;
			}
		}
		return count.size() == set.size();
		
//		Set<Integer> set = new HashSet<>();
//		Arrays.sort(arr);
//		int count = 1;
//		for(int i = 1;i < arr.length;i ++){
//			if(arr[i] != arr[i - 1]){
//				if(!set.add(count)){
//					return false;
//				}
//				count = 1;
//			}else{
//				count ++;
//			}
//		}
//		if(!set.add(count)){
//			return false;
//		}
//		return true;
	}
	
	public static void main(String[] args) {
		Problem_1207_UniqueNumberofOccurrences solution = new Problem_1207_UniqueNumberofOccurrences();
		int[] arr = {1,1,2,2,3,3};
		System.out.println(solution.uniqueOccurrences(arr));
	}
}
