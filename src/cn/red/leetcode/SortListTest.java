package cn.red.leetcode;

// 链表的数据结构
class LinkedListNode {
	int val;
	LinkedListNode next;
	
	public LinkedListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortListTest {
	
	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(5);
		LinkedListNode second = new LinkedListNode(4);
		LinkedListNode third = new LinkedListNode(3);
		LinkedListNode forth = new LinkedListNode(2);
		LinkedListNode fifth = new LinkedListNode(1);
		
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		
		LinkedListNode node = SortListTest.mergeSort(first);
		System.out.println(node.next.next.next.next.val);
	}
	
	// 寻找中间节点（快慢指针）
	public static LinkedListNode getMiddleOfListNode(LinkedListNode pHead) {
		LinkedListNode fast = pHead;
		LinkedListNode slow = pHead;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	// 归并两个有序链表
	public static LinkedListNode merge(LinkedListNode pHead1, LinkedListNode pHead2) {
		if (pHead1 == null) {
			return pHead2;
		}
		if (pHead2 == null) {
			return pHead1;
		}
		
		LinkedListNode pMergeHead = null;
		
		if (pHead1.val < pHead2.val) {
			pMergeHead = pHead1;
			pMergeHead.next = merge(pHead1.next, pHead2);
		} else {
			pMergeHead = pHead2;
			pMergeHead.next = merge(pHead1, pHead2.next);
		}
		
		return pMergeHead;
	}
	
	// 排序两个有序的链表
	public static LinkedListNode mergeSort(LinkedListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		// 把两个链表分为左右两个链表
		LinkedListNode middle = getMiddleOfListNode(pHead);
		LinkedListNode next = middle.next;
		middle.next = null;
		
		return merge(mergeSort(pHead), mergeSort(next));
	}
	
}
