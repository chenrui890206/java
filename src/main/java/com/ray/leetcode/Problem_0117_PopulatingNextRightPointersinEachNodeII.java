package com.ray.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.


Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:
		  1                     1 ->null
	   /    \                 /   \
	  2      3               2 ->  3 ->null
	 / \      \             / \   / \
	4   5      7           4 ->5 ->  7 ->null


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A),
your function should populate each next pointer to point to its next right node,
just like in Figure B. The serialized output is in level order as connected by the next pointers,
with '#' signifying the end of each level.

*/
public class Problem_0117_PopulatingNextRightPointersinEachNodeII {
	
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;
		
		public Node() {}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
	
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (! queue.isEmpty()) {
			int size = queue.size();
			Node pre = null;
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (i != 0) {
					pre.next = node;
				}
				pre = node;
			}
			
		}
		return root;
	}
	
	/**
	 * 不用队列的方式
	 * @param root
	 * @return
	 */
	public Node connect2(Node root) {
		if (root == null) return root;
		Node cur = root;
		while (cur != null) {           //控制cur到下一层的循环
			Node dumm = new Node();   //创建一个虚拟头结点(每一层都会创建)
			Node tail = dumm;         //维护一个尾节点指针（初始化是虚拟节点）
			
			while (cur != null) {        //控制cur同一层的循环
				if (cur.left != null) {  //判断cur的左节点是否为空，不为空时就是cur的下一层的第一个节点了
					tail.next = cur.left;
					tail = tail.next;
				}
				if (cur.right != null) {  //判断cur的右节点是否为空，此时不为空时就是cur的下一层的第一个节点了
					tail.next = cur.right;
					tail = tail.next;
				}
				cur = cur.next;         //cur同层移动到下一位置
			}
			cur = dumm.next;            //内循环结束，开始cur的下一层
		}
		return root;
	}
	
	public static void main(String[] args) {
		Problem_0117_PopulatingNextRightPointersinEachNodeII solution = new Problem_0117_PopulatingNextRightPointersinEachNodeII();
		Node head = solution.new Node(1);
		head.left = solution.new Node(2);
		head.right = solution.new Node(3);
		head.left.left = solution.new Node(4);
		head.left.right = solution.new Node(5);
		head.right.right = solution.new Node(7);
		solution.connect(head);
		System.out.println(111);
	}
}
