package cn.red.offer.second;


/**
 * 链表中倒数第k个节点
 * @author sala
 *
 */
public class Problem22 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);

		head.next = second;
		second.next = third;
		third.next = forth;

		Problem22 fkln = new Problem22();
		ListNode tail = fkln.FindKthToTail(head, 3);
		System.out.println(tail.val);
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}

		ListNode resultListNode = null;
		ListNode headListNode = head;

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
