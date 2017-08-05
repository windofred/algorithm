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
		RandomListNode A = new RandomListNode(1);
		RandomListNode B = new RandomListNode(2);
		RandomListNode C = new RandomListNode(3);
		RandomListNode D = new RandomListNode(4);
		RandomListNode E = new RandomListNode(5);

		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;

		A.random = C;
		D.random = B;
		B.random = E;

		RandomListNode result = p26.Clone(A);
		System.out.println(result.next.label);

	}

	public RandomListNode Clone(RandomListNode pHead) {

		if (pHead == null) {
			return null;
		}
		// 复制结点
		RandomListNode currentNode = pHead;
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			cloneNode.next = currentNode.next;
			currentNode.next = cloneNode;
			currentNode = cloneNode.next;
		}
		// 复制指针指向
		currentNode = pHead;
		while (currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			if (currentNode.random != null) {
				cloneNode.random = currentNode.random.next;
			}
			currentNode = cloneNode.next;
		}
		// 拆分长链
		currentNode = pHead;
		RandomListNode cloneHead = pHead.next;
		RandomListNode tempNode;
		while (currentNode.next != null) {
			tempNode = currentNode.next;
			currentNode.next = tempNode.next;
			currentNode = tempNode;
		}
		return cloneHead;
	}

	// 1.复制原始链表的任意结点N并创建新结点N'，再把N'链接到N的后面
	public void cloneNodes(RandomListNode pHead) {

		RandomListNode pNode = pHead;

		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(pNode.label);
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
