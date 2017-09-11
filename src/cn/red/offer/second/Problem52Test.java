package cn.red.offer.second;

public class Problem52Test {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode second1 = new ListNode(2);
		ListNode third1 = new ListNode(3);
		ListNode forth1 = new ListNode(6);
		ListNode fifth1 = new ListNode(7);
		
		ListNode head2 = new ListNode(4);
		ListNode second2 = new ListNode(5);
		ListNode third2 = new ListNode(6);
		ListNode forth2 = new ListNode(7);
		
		head1.next = second1;
		second1.next = third1;
		third1.next = forth1;
		forth1.next = fifth1;
		
		head2.next = second2;
		second2.next = forth1;
		third2.next = fifth1;
		
		ListNode firstCommonNode = getFirstCommonNode(head1, head2);
		System.out.println(firstCommonNode.val);
	}

	public static ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
		int len1 = getLengthOfList(head1);
		int len2 = getLengthOfList(head2);
		int diff = len1 - len2;

		ListNode fast = head1;
		ListNode slow = head2;
		if (len2 > len1) {
			fast = head2;
			slow = head1;
			diff = len2 - len1;
		}

		// 让长的链表先走(k - 1)步
		for (int i = 0; i < diff; i++) {
			fast = fast.next;
		}

		while (fast != null && slow != null && fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;

	}

	// 获得链表的长度
	public static int getLengthOfList(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
}
