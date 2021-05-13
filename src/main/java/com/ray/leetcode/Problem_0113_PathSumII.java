package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

*/
public class Problem_0113_PathSumII {
	
	List<List<Integer>> path = new ArrayList<>();
	List<Integer> x = new ArrayList<>();
	int total = 0;
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return path;
		}
		process(root, sum);
		return path;
	}
	
	public TreeNode process(TreeNode node, int sum) {
		if (node == null) {
			return null;
		}
		//每来到一个节点，累加到total，并加入路径集合x中
		total += node.val;
		x.add(node.val);
		TreeNode left = process(node.left, sum);
		TreeNode right = process(node.right, sum);
		//如果是左右都没有，那么就是叶子节点
		if (left == null && right == null) {
			//累加到==sum，那么加入path中
			if (total == sum) {
				path.add(new ArrayList<>(x));
			}
		}
		//每次return前，删除x，并在total减去节点值，还原
		x.remove(x.size() - 1);
		total -= node.val;
		return node;
	}
	
	public static void main(String[] args) {
		Problem_0113_PathSumII solution = new Problem_0113_PathSumII();
		TreeNode head = solution.new TreeNode(1);
		head.left = solution.new TreeNode(2);
		head.right = solution.new TreeNode(3);
		head.left.left = solution.new TreeNode(4);
		head.left.right = solution.new TreeNode(7);
		head.right.left = solution.new TreeNode(6);
		head.right.right = solution.new TreeNode(7);
		List<List<Integer>> lists = solution.pathSum(head, 10);
		System.out.println(lists);
	}
}
