package com.ray.leetcode;

/**
 * @Description
 * @Package: com.ray.leetcode
 * @Author: Ray
 * @CreateTime: 2020/9/23 10:07
 * @E-mail: 634302021@qq.com
 */
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
