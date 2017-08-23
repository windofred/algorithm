package cn.red.offer.second;

/**
 * 合并两个有序的链表
 * @author red
 *
 */

class ListNode_25 {
	int val;
	ListNode_25 next = null;
	
	public ListNode_25(int val) {
		this.val = val;
	}
}

public class Problem25 {
	
	public static void main(String[] args) {
		ListNode_25 first1 = new ListNode_25(1);
		ListNode_25 second1 = new ListNode_25(3);
		ListNode_25 third1 = new ListNode_25(5);
		ListNode_25 forth1 = new ListNode_25(7);
		first1.next = second1;
		second1.next = third1;
		third1.next = forth1;
		forth1.next = null;
		
		ListNode_25 first2 = new ListNode_25(2);
		ListNode_25 second2 = new ListNode_25(4);
		ListNode_25 third2 = new ListNode_25(6);
		ListNode_25 forth2 = new ListNode_25(8);
		first2.next = second2;
		second2.next = third2;
		third2.next = forth2;
		forth2.next = null;
		
		Problem25 p25 = new Problem25();
		
		ListNode_25 node = p25.merge(first1, first2);
		System.out.println(node.next.val);
	}
	
	public ListNode_25 merge(ListNode_25 pHead1, ListNode_25 pHead2) {
		if (pHead1 == null) {
			return pHead2;
		}
		if (pHead2 == null) {
			return pHead1;
		}
		
		ListNode_25 pMergeHead = null;
		
		if (pHead1.val < pHead2.val) {
			pMergeHead = pHead1;
			pMergeHead.next = merge(pHead1.next, pHead2);
		} else {
			pMergeHead = pHead2;
			pMergeHead.next = merge(pHead1, pHead2.next);
		}
		
		return pMergeHead;
	}
	
}
