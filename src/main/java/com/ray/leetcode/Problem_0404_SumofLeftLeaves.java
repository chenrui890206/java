package com.ray.leetcode;

/*
Find the sum of all left leaves in a given binary tree.
		
		Example:
		
		  3
		 / \
		9  20
		/  \
	   15   7
		
There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

public class Problem_0404_SumofLeftLeaves {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	static int sum = 0;
	
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		dfs(root, 0);
		return sum;
	}
	
	//fPaht:记录父节点到子结点的路径——1:左孩子, -1:右孩子
	public void dfs(TreeNode root, int fPath) {
		if (root.left == null && root.right == null && fPath == 1) {
			sum += root.val;
		}
		if (root.left != null) {
			dfs(root.left, 1);
		}
		if (root.right != null) {
			dfs(root.right, - 1);
		}
	}
	
	public static void main(String[] args) {
		Problem_0404_SumofLeftLeaves solution = new Problem_0404_SumofLeftLeaves();
		TreeNode head = solution.new TreeNode(3);
		TreeNode headleft = solution.new TreeNode(9);
		TreeNode headright = solution.new TreeNode(20);
		TreeNode headrightleft = solution.new TreeNode(15);
		TreeNode headrightright = solution.new TreeNode(7);
		head.left = headleft;
		head.right = headright;
		headright.left = headrightleft;
		headright.right = headrightright;
		System.out.println(solution.sumOfLeftLeaves(head));
	}
}
