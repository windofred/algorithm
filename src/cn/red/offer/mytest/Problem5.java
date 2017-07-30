package cn.red.offer.mytest;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * 链表
 * 
 * 面试题5：从尾到头输出链表
 * 
 * @author red
 *
 */

class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
}

public class Problem5 {
	
	@Test
	public void test1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
		Problem5 p5 = new Problem5();
		//p5.printListReverse(node1);
		ArrayList<Integer> list = p5.printListFromTailToHead(node1);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	// 非递归实现
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
		return list;
	}
	
	
	
	// 递归实现
	public void printListReverse(ListNode headNode) {
		if (headNode != null) {
			if (headNode.next != null) {
				printListReverse(headNode.next);
			}
			System.out.println(headNode.val);
		}
	}

}
