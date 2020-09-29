package com.ray.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

*/
public class Problem_0145_BinaryTreePostorderTraversal {
	
	List<Integer> result = new ArrayList<>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {}
		
		TreeNode(int val) { this.val = val; }
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.peek();
			if (root.right == null || root.right == prev) {
				stack.pop();
				res.add(root.val);
				prev = root;
				root = null;
			} else {
				root = root.right;
			}
		}
		return res;
	}

	
	public static void main(String[] args) {
		Problem_0145_BinaryTreePostorderTraversal solution = new Problem_0145_BinaryTreePostorderTraversal();
		TreeNode head = solution.new TreeNode(1);
		head.left = solution.new TreeNode(2);
		head.left.left = solution.new TreeNode(4);
		head.left.right = solution.new TreeNode(5);
		head.right = solution.new TreeNode(3);
		head.right.left = solution.new TreeNode(6);
		head.right.right = solution.new TreeNode(7);
		System.out.println(solution.postorderTraversal(head));
	}
}
