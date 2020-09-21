package com.ray.leetcode;

/*
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

* */
public class Problem_0021_MergeTwoSortedLists {
	
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
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode p = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		Problem_0021_MergeTwoSortedLists solution = new Problem_0021_MergeTwoSortedLists();
		ListNode l1 = solution.new ListNode(2);
		ListNode l2 = solution.new ListNode(3);
		ListNode l3 = solution.new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = solution.new ListNode(3);
		ListNode l5 = solution.new ListNode(4);
		ListNode l6 = solution.new ListNode(7);
		l4.next = l5;
		l5.next = l6;
		ListNode head = solution.mergeTwoLists(l1, l4);
		System.out.println(head);
	}
}
