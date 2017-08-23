package cn.red.offer;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

/**
 * 删除链表节点
 * 
 * @author red
 *
 */
public class DeleteListNode {

	public static void main(String[] args) {

	}

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		
		ListNode pPreNode = null;
		ListNode pNode = pHead;
		
		while (pNode != null) {
			ListNode pNext = pNode.next;
			boolean needDelete = false;
			if (pNext != null && pNext.val == pNode.val) {
				needDelete = true;
			}
			
			if (!needDelete) {
				pPreNode = pNode;
				pNode = pNode.next;
			} else {
				int value = pNode.val;
				ListNode pToBeDel = pNode;
				
			}
			
			
		}
		
		return pHead;
	}

	/*
	 * public static void main(String[] args) { ListNode head = new ListNode(1);
	 * ListNode second = new ListNode(2); ListNode third = new ListNode(3);
	 * 
	 * head.next = second; second.next = third; third.next = null;
	 * 
	 * DeleteListNode dln = new DeleteListNode(); dln.deleteNode(head, third);
	 * System.out.println(head.next.val); }
	 * 
	 * public void deleteNode(ListNode head, ListNode deListNode) {
	 * 
	 * if (head == null || deListNode == null) { return; }
	 * 
	 * // 链表中不止一个节点，删除的不是尾节点（即删除的节点都存在后继节点） if (deListNode.next != null) {
	 * ListNode nextNode = deListNode.next; deListNode.val = nextNode.val;
	 * deListNode.next = nextNode.next; } else if (deListNode == head) {//
	 * 链表中只有一个节点（删除的既是头节点，也是尾节点） head = head.next; deListNode = null; } else {//
	 * 链表中不止一个节点，删除的是尾节点（即删除的节点不存在后继节点） ListNode node = head; while (node.next
	 * != deListNode) { node = node.next; } node.next = null; deListNode = null;
	 * }
	 * 
	 * }
	 */

}
