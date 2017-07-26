package com.red.newcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * @author red
 *
 */
public class TraverseListNode {

	// 测试代码
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = null;
		
		ArrayList<Integer> list = TraverseListNode.printListFromTailToHead(listNode1);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	// 遍历链表
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		// 压栈
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		// 出栈
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
		return list;
	}

}
