package com.ray.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

* */
public class Problem_0106_ConstructBinaryTreefromInorderandPostorderTraversal {
	
	static Map<Integer,Integer> map = new HashMap<>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}
		//构建中序map，key=元素，value=元素下标
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}
	
	public TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
		if (inL > inR) {
			return null;
		}
		int rootVal = postorder[postR - 1];
		int rootIndex = map.get(rootVal);
		//中序左边的个数
		int leftCount =
	}
	
	public static void main(String[] args) {
		Problem_0106_ConstructBinaryTreefromInorderandPostorderTraversal solution = new Problem_0106_ConstructBinaryTreefromInorderandPostorderTraversal();
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		solution.buildTree(inorder, postorder);
	}
}
