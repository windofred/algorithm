package cn.red.offer;

/**
 * 反转链表并返回反转后的头结点
 * @author red
 *
 */

class ListNode3 {
	int val;
	ListNode3 next = null;
	ListNode3(int val) {
		this.val = val;
	}
}

public class ReverseListNode {
	
	public static void main(String[] args) {
		ListNode3 head = new ListNode3(1);
		ListNode3 second = new ListNode3(2);
		ListNode3 third = new ListNode3(3);
		ListNode3 forth = new ListNode3(4);
		
		head.next = second;
		second.next = third;
		third.next = forth;
		
		ReverseListNode fkln = new ReverseListNode();
		ListNode3 first = fkln.ReverseList(head);
		
		ListNode3 temp = first;
		for (int i = 0; i < 4; i++) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public ListNode3 ReverseList(ListNode3 head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode3 preListNode = null;
		ListNode3 nowListNode = head;
		ListNode3 reverseHead = null;
		while (nowListNode != null) {
			ListNode3 nextListNode = nowListNode.next;
			if (nextListNode == null) {
				reverseHead = nowListNode;
			}
			nowListNode.next = preListNode;
			preListNode = nowListNode;
			nowListNode = nextListNode;
		}
		return reverseHead;
    }
	
	private void traverseList(ListNode3 head) {
		
	}
}
