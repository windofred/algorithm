package cn.red.offer.mytest;

/**
 * 
 * 链表
 * 
 * 面试题26：复杂链表的复制
 * 
 * @author red
 *
 */

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;
	
	public RandomListNode(int label) {
		this.label = label;
	}
	
}

public class Problem26 {
	
	public static void main(String[] args) {
		Problem26 p26 = new Problem26();
		RandomListNode root = new RandomListNode(1);
		RandomListNode node1 = new RandomListNode(2);
		RandomListNode node2 = new RandomListNode(3);
		RandomListNode node3 = new RandomListNode(4);
		RandomListNode node4 = new RandomListNode(5);
		
		root.label = 1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		root.random = node1;
		node1.random = root;
		node3.random = node1;
		
		RandomListNode result = p26.Clone(root);
		System.out.println(result.label);
		
		
	}
	
	public RandomListNode Clone(RandomListNode pHead) {
        
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		
		
		return reconnectNodes(pHead);
    }
	
	// 1.复制原始链表的任意结点N并创建新结点N'，再把N'链接到N的后面
	public void cloneNodes(RandomListNode pHead) {
		
		RandomListNode pNode = pHead;
		
		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(0);
			pCloned.label = pNode.label;
			pCloned.next = pNode.next;
			pCloned.random = null;
			
			pNode.next = pCloned;
			pNode = pCloned.next;
		}
	}
	
	// 2.如果原始链表上的结点N的random指向S，则对应的复制结点N'的random指向S的下一结点S'
	public void connectRandomNodes(RandomListNode pHead) {
		
		RandomListNode pNode = pHead;
		
		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(0);
			if (pNode.random != null) {
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
		}
	}
	
	// 3.第三步把这个长链表拆分成两个链表：把奇数位置的结点用next链接起来就是原始链表
	// 把偶数位置的结点用next链接起来就是复制出来的链表
	public RandomListNode reconnectNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		
		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		while (pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		return pClonedHead;
	}
	
}
