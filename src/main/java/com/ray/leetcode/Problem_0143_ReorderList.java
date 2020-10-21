package com.ray.leetcode;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/
public class Problem_0143_ReorderList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode pre = null;
		ListNode o = head;
		ListNode tmp = head;
		while (head != null) {
			System.out.println(head.val);
			tmp = head.next;
//			o.next = tmp;
//			o = o.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		printLinkedList(pre);
		printLinkedList(o);
		
	}
	
	public static void printLinkedList(ListNode node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Problem_0143_ReorderList solution = new Problem_0143_ReorderList();
		ListNode head = solution.new ListNode(1);
		head.next = solution.new ListNode(2);
		head.next.next = solution.new ListNode(3);
		head.next.next.next = solution.new ListNode(4);
		head.next.next.next.next = solution.new ListNode(5);
		solution.reorderList(head);
//		printLinkedList(head);
	}
}
