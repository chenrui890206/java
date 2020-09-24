package com.ray.leetcode;

import java.util.*;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

* */
public class Problem_0501_FindModeinBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	public class Item{
		Integer num;
		Integer count;
		
		public Item(int n, int c) {
			this.num = n;
			this.count = c;
		}
	}
	
	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[]{};
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer,Integer> counts = new HashMap<>();
		while (! queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				counts.put(node.val, counts.getOrDefault(node.val, 0) + 1);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		PriorityQueue<Item> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
		counts.forEach((k,v) ->{
			priorityQueue.add(new Item(k, v));
		});
		List<Integer> list = new ArrayList<>();
		int num = priorityQueue.peek().count;
		while (! priorityQueue.isEmpty() && priorityQueue.peek().count == num) {
			list.add(priorityQueue.poll().num);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		Problem_0501_FindModeinBinarySearchTree solution = new Problem_0501_FindModeinBinarySearchTree();
		TreeNode head = solution.new TreeNode(1);
		head.left = solution.new TreeNode(2);
		head.right = solution.new TreeNode(3);
		head.right.left = solution.new TreeNode(2);
		head.right.right = solution.new TreeNode(3);
		System.out.println(Arrays.toString(solution.findMode(head)));
	}
}
