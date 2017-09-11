package cn.red.leetcode.reorder.list;

public class HasCycleTest {
	public static ListNode hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode p = head;
				ListNode q = fast;
				while (p != q) {
					p = p.next;
					q = q.next;
				}
				return p;
			}
		}
		
		return null;
	}
}
