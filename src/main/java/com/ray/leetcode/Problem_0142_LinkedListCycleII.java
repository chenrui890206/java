package com.ray.leetcode;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?

*/
public class Problem_0142_LinkedListCycleII {
	
	class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (true) {
			if (fast == null || fast.next == null) return null;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) break;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		Problem_0142_LinkedListCycleII solution = new Problem_0142_LinkedListCycleII();
		ListNode head = solution.new ListNode(3);
		head.next = solution.new ListNode(2);
		head.next.next = solution.new ListNode(0);
		head.next.next.next = solution.new ListNode(- 4);
		head.next.next.next.next = head.next.next;
		System.out.println(solution.detectCycle(head));
	}
}
