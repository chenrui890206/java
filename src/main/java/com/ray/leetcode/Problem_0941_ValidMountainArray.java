package com.ray.leetcode;

/*
iven an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false

*/
public class Problem_0941_ValidMountainArray {
	
	public boolean validMountainArray(int[] A) {
		if (A == null || A.length < 3) {
			return false;
		}
		int pos = 0;
		while (pos < A.length - 1 && A[pos] < A[pos + 1]) {
			pos++;
		}
		if (pos == A.length - 1 || pos == 0) {
			return false;
		}
		while (pos < A.length - 1 && A[pos] > A[pos + 1]) {
			pos++;
		}
		return pos == A.length - 1;
	}
	
	public static void main(String[] args) {
		Problem_0941_ValidMountainArray solution = new Problem_0941_ValidMountainArray();
		int[] A = {9,8,7,6,5,4,3,2,1,0};
		boolean b = solution.validMountainArray(A);
		System.out.println(b);
	}
}
