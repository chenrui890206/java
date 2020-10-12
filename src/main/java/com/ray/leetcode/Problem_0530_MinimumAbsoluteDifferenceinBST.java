package com.ray.leetcode;

/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note:

There are at least two nodes in this BST.
This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*/
public class Problem_0530_MinimumAbsoluteDifferenceinBST {
	
	public static int lastValue= Integer.MAX_VALUE;
	public static int result = Integer.MAX_VALUE;
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public int getMinimumDifference(TreeNode root) {
		process(root);
		return result;
	}
	
	public void process(TreeNode root) {
		if (root == null) {
			return;
		}
		process(root.left);
		result = Math.min(result, Math.abs(root.val - lastValue));
		lastValue = root.val;
		process(root.right);
	}
	
	public static void main(String[] args) {
		Problem_0530_MinimumAbsoluteDifferenceinBST solution = new Problem_0530_MinimumAbsoluteDifferenceinBST();
		TreeNode head = solution.new TreeNode(1);
		head.right = solution.new TreeNode(5);
		head.right.left = solution.new TreeNode(3);
		System.out.println(solution.getMinimumDifference(head));
	}
}
