package cn.red.offer.second;

/**
 * 反转链表
 * @author red
 *
 */

class ListNode_24 {
	int val;
	ListNode_24 next;
	
	public ListNode_24(int val) {
		this.val = val;
	}
}

public class Problem24 {
	
	public static void main(String[] args) {
		ListNode_24 first = new ListNode_24(1);
		ListNode_24 second = new ListNode_24(2);
		ListNode_24 third = new ListNode_24(3);
		ListNode_24 forth = new ListNode_24(4);
		ListNode_24 fifth = new ListNode_24(5);
		
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		
		Problem24 p24 = new Problem24();
		ListNode_24 node = p24.reverseListNode(null);
		
		System.out.println(node.next.val);
	}
	
	public ListNode_24 reverseListNode(ListNode_24 pHead) {
		
		if (pHead == null) {
			return null;
		}
		
		ListNode_24 pReversedHead = null;
		ListNode_24 pNode = pHead;
		ListNode_24 pPrev = null;
		
		while (pNode != null) {
			ListNode_24 pNext = pNode.next;
			if (pNext == null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			
			pPrev = pNode;
			pNode = pNext;
		}
		
		return pReversedHead;
	}
	
}
