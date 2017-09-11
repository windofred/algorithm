package cn.red.leetcode;

public class RandomListNodeTest {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}
		// ①复制链表节点
		RandomListNode node = head;
		
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			newNode.next = node.next;
			node.next = newNode;
			node = newNode.next;
		}
		
		// ②设置复制出来的节点的random
		node = head;
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		
		// ③将链表拆分成两个链表
		RandomListNode newHead = head.next;
		node = head;
		while (node != null) {
			RandomListNode newNode = node.next;
			node.next = newNode.next;
			if (newNode.next != null) {
				newNode.next = newNode.next.next;
			}
			node = newNode.next;
		}
		
		return newHead;
	}
}
