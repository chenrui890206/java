package com.ray.leetcode;

import java.util.Arrays;

/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.


Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Note:

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
*/
public class Problem_0922_SortArrayByParityII {
	
	public int[] sortArrayByParityII(int[] A) {
		if (A == null) {
			return null;
		}
		int[] result = new int[A.length];
		int[] odd = new int[A.length / 2];
		int odd_index = 0;
		int[] even = new int[A.length / 2];
		int even_index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				even[even_index] = A[i];
				even_index++;
			} else {
				odd[odd_index] = A[i];
				odd_index++;
			}
		}
		odd_index =0;
		even_index =0;
		for (int i = 0; i < A.length; i++) {
			if (i % 2 == 0) {
				result[i] = even[even_index];
				even_index++;
			} else {
				result[i] = odd[odd_index];
				odd_index++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem_0922_SortArrayByParityII solution = new Problem_0922_SortArrayByParityII();
		int[] A = {4,2,5,7};
		System.out.println(Arrays.toString(solution.sortArrayByParityII(A)));
	}
}
