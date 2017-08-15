package cn.red.offer.second;

/**
 * 
 * 两个链表的第一个公共节点
 * 
 * @author red
 *
 */
public class Problem52 {
	
	public static void main(String[] args) {
		Problem52 p52 = new Problem52();
		
		ListNode pHead1 = new ListNode(1);
		ListNode node1_1 = new ListNode(2);
		ListNode node1_2 = new ListNode(3);
		ListNode node1_3 = new ListNode(6);
		ListNode node1_4 = new ListNode(7);
		pHead1.next = node1_1;
		node1_1.next = node1_2;
		node1_2.next = node1_3;
		node1_3.next = node1_4;
		
		ListNode pHead2 = new ListNode(4);
		ListNode node2_1 = new ListNode(5);
		ListNode node2_2 = new ListNode(6);
		ListNode node2_3 = new ListNode(7);
		pHead2.next = node2_1;
		node2_1.next = node2_2;
		node2_2.next = node2_3;
		
		ListNode commonNode = p52.FindFirstCommonNode(pHead1, pHead2);
		System.out.println(commonNode.next.val);
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int nLength1 = getListLength(pHead1);
		int nLength2 = getListLength(pHead2);
		int nLengthDif = nLength1 - nLength2;
		
		ListNode pListHeadLong = pHead1;
		ListNode pListHeadShort = pHead2;
		if (nLength2 > nLength1) {
			pListHeadLong = pHead2;
			pListHeadShort = pHead1;
			nLengthDif = nLength2 - nLength1;
		}
		
		for (int i = 0; i < nLengthDif; i++) {
			pListHeadLong = pListHeadLong.next;
		}
		
		//boolean b = (pListHeadLong != null) && (pListHeadShort != null) && (pListHeadLong != pListHeadShort);
		while (pListHeadLong != null && pListHeadShort != null && pListHeadLong.val != pListHeadShort.val) {
			pListHeadLong = pListHeadLong.next;
			pListHeadShort = pListHeadShort.next;
		}
		
		ListNode pFirstCommonNode = pListHeadLong;
		
		return pFirstCommonNode;
	}

	/**
	 * 得到链表的长度
	 * 
	 * @param pHead
	 * @return
	 */
	public int getListLength(ListNode pHead) {
		int nLength = 0;
		ListNode pNode = pHead;
		while (pNode != null) {
			++nLength;
			pNode = pNode.next;
		}

		return nLength;
	}

}

class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}
}
