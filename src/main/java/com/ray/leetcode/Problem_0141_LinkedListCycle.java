package com.ray.leetcode;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?

*/
public class Problem_0141_LinkedListCycle {
	
	class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (true) {
			if (fast == null || fast.next == null) return false;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) break;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem_0141_LinkedListCycle solution = new Problem_0141_LinkedListCycle();
		ListNode head = solution.new ListNode(3);
		head.next = solution.new ListNode(2);
		head.next.next = solution.new ListNode(0);
		head.next.next.next = solution.new ListNode(- 4);
		head.next.next.next.next = head.next.next;
		System.out.println(solution.hasCycle(head));
	}
}
