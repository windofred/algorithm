package cn.red.offer;

class ListNode2 {
	int val;
	ListNode2 next = null;
	ListNode2(int val) {
		this.val = val;
	}
}

public class FindKthListNode {
	
	public static void main(String[] args) {
		ListNode2 head = new ListNode2(1);
		ListNode2 second = new ListNode2(2);
		ListNode2 third = new ListNode2(3);
		ListNode2 forth = new ListNode2(4);
		
		head.next = second;
		second.next = third;
		third.next = forth;
		
		FindKthListNode fkln = new FindKthListNode();
		ListNode2 tail = fkln.FindKthToTail(head, 3);
		System.out.println(tail.val);
	}
	
	public ListNode2 FindKthToTail(ListNode2 head,int k) {
		if (head == null || k == 0) {
			return null;
		}
		
		ListNode2 resultListNode = null;
		ListNode2 headListNode = head;
		
		for (int i = 0; i < k - 1; i++) {
			if (headListNode.next != null) {
				headListNode = headListNode.next;
			} else {
				return null;
			}
		}
		
		resultListNode = head;
		while (headListNode.next != null) {
			headListNode = headListNode.next;
			resultListNode = resultListNode.next;
		}
		
		return resultListNode;
    }
}
