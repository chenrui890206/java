package com.ray.leetcode;

/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

* */
public class Problem_0538_ConvertBSTtoGreaterTree {
	static int res = 0;
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		process(root);
		return root;
	}
	
	public void process(TreeNode root) {
		if (root == null) {
			return;
		}
		process(root.right);
		res += root.val;
		root.val = res;
		process(root.left);
	}
	
	public static void main(String[] args) {
		Problem_0538_ConvertBSTtoGreaterTree solution = new Problem_0538_ConvertBSTtoGreaterTree();
		TreeNode head = solution.new TreeNode(2);
		TreeNode headleft = solution.new TreeNode(0);
		TreeNode headright = solution.new TreeNode(3);
		TreeNode headleftleft = solution.new TreeNode(- 4);
		TreeNode headleftright = solution.new TreeNode(1);
		head.left = headleft;
		head.right = headright;
		headleft.left = headleftleft;
		headleft.right = headleftright;
		System.out.println(solution.convertBST(head));
	}

}
