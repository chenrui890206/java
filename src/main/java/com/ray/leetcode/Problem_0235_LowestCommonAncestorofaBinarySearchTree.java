package com.ray.leetcode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
				  6
			   /    \
			  2      8
			 / \    / \
			0   4   7  9
			   / \
			  3   5


Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


Constraints:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.

*/
public class Problem_0235_LowestCommonAncestorofaBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (ancestor != null) {
			if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {    //一旦遍历到分叉，那么就是最小公共祖先
				break;
			}
		}
		return ancestor;

	}
	
	public static void main(String[] args) {
		Problem_0235_LowestCommonAncestorofaBinarySearchTree solution = new Problem_0235_LowestCommonAncestorofaBinarySearchTree();
		TreeNode head = solution.new TreeNode(5);
		head.left = solution.new TreeNode(3);
		head.right = solution.new TreeNode(6);
		head.left.left = solution.new TreeNode(2);
		head.left.right = solution.new TreeNode(4);
		//		head.left.right.left = solution.new TreeNode(3);
		//		head.left.right.right = solution.new TreeNode(5);
		//		head.right.left = solution.new TreeNode(7);
		//		head.right.right = solution.new TreeNode(9);
		head.left.left.left = solution.new TreeNode(1);
		
		System.out.println(solution.lowestCommonAncestor(head, head.left.left.left, head.left).val);
	}
}
