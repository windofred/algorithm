package cn.red.leetcode.reorder.list;


/**
 * 重新排序链表
 * 
 * @author sala
 *
 */
public class ReorderListTest {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		// ListNode forth = new ListNode(4);
		// ListNode fifth = new ListNode(1);

		first.next = second;
		second.next = third;
		third.next = null;
		// forth.next = fifth;
		// forth.next = null;

		ReorderListTest.reorderList(first);
		// System.out.println(node.val);
		// System.out.println(node.next.val);

		// ListNode reorderList = ReorderListTest.reorderList(first);
		// System.out.println(reorderList.next.val);
	}

	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}

		ListNode middle = getMiddleOfListNode(head);

		ListNode head2 = reverseList(middle.next);
		middle.next = null;
		ListNode head1 = head;
		// 创建一个临时节点作为头节点
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		// 当子链表都不为空的时候依次合并
		while (head2 != null && head1 != null) {
			// 先访问head1
			curr.next = head1;
			head1 = head1.next;
			curr = curr.next;
			// 再访问head2
			curr.next = head2;
			head2 = head2.next;
			curr = curr.next;
		}
		// 当其中一个子链表为空时，把另一个链表剩下的那个节点加上，因为可能一共有奇数个节点
		curr.next = head2 != null ? head2 : null;
		curr.next = head1 != null ? head1 : null;
		// 去掉dummyHead临时节点
		head = dummyHead.next;
		
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		// System.out.println(node.next.next.next.val);
	}

	// 获得链表的中间节点
	public static ListNode getMiddleOfListNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// 迭代反转链表(思想比较重要)
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}

		head.next = null;
		return p1;
	}

}
