package cn.red.offer.second;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author red
 *
 */

class ListNode_6 {
	int val;
	ListNode_6 next = null;
	
	public ListNode_6(int val) {
		this.val = val;
	}
}

public class Problem6 {
	
	public static void main(String[] args) {
		ListNode_6 first = new ListNode_6(1);
		ListNode_6 second = new ListNode_6(2);
		ListNode_6 third = new ListNode_6(3);
		ListNode_6 forth = new ListNode_6(4);
		ListNode_6 fifth = new ListNode_6(5);
		
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;
		
		Problem6 p6 = new Problem6();
		p6.printListNode(first);
		
	}
	
	public void printListNode(ListNode_6 pHead) {
		if (pHead == null) {
			return;
		}
		
		Stack<ListNode_6> nodes = new Stack<ListNode_6>();
		ListNode_6 pNode = pHead;
		while (pNode != null) {
			nodes.push(pNode);
			pNode = pNode.next;
		}
		
		while (!nodes.isEmpty()) {
			pNode = nodes.peek();
			System.out.print(pNode.val + " ");
			nodes.pop();
		}
	}
	
}
