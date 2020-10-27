package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

*/
public class Problem_0144_BinaryTreePreorderTraversal {
	
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
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (! stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem_0144_BinaryTreePreorderTraversal solution = new Problem_0144_BinaryTreePreorderTraversal();
		TreeNode head = solution.new TreeNode(1);
		head.left = solution.new TreeNode(2);
		head.right = solution.new TreeNode(3);
		System.out.println(solution.preorderTraversal(head));
	}
	
}
