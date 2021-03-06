package com.ray.leetcode;

/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7

* */
public class Problem_0617_MergeTwoBinaryTrees {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
		root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
		return root;
	}
	
	public static void main(String[] args) {
		Problem_0617_MergeTwoBinaryTrees solution = new Problem_0617_MergeTwoBinaryTrees();
		TreeNode head1 = solution.new TreeNode(1);
		head1.left = solution.new TreeNode(3);
		head1.right = solution.new TreeNode(2);
		head1.left.left = solution.new TreeNode(5);
		
		TreeNode head2 = solution.new TreeNode(2);
		head2.left = solution.new TreeNode(1);
		head2.right = solution.new TreeNode(3);
		head2.left.right = solution.new TreeNode(4);
		head2.right.right = solution.new TreeNode(7);
		solution.mergeTrees(head1, head2);
	}
}
