package cn.red.offer.second;

/**
 * 链表中环的入口节点
 * @author sala
 *
 */
public class Problem23 {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		
		ListNode node = Problem23.entryNodeOfLoop(node1);
		System.out.println(node.val);
	}
	
	public static ListNode entryNodeOfLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 第一次相遇(环内相遇)，fast置为head，每次移动一步
			if (slow.val == fast.val) {
				fast = head;
				while (slow.val != fast.val) {
					slow = slow.next;
					fast = fast.next;
				}
			}
			// 第二次相遇，即为入口节点
			if (fast.val == slow.val) {
				return slow;
			}
		}
		return null;
	} 
	
}
