package com.ray.leetcode;

/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

*/
public class Problem_0222_CountCompleteTreeNodes {
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
	
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		return left + right + 1;
	}
	
	public static void main(String[] args) {
		Problem_0222_CountCompleteTreeNodes solution = new Problem_0222_CountCompleteTreeNodes();
		TreeNode head = solution.new TreeNode(1);
		head.left = solution.new TreeNode(2);
		head.left.left = solution.new TreeNode(3);
		head.right = solution.new TreeNode(4);
		head.right.left = solution.new TreeNode(5);
		System.out.println(solution.countNodes(head));
	}
}
