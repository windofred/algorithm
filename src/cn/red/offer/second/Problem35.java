package cn.red.offer.second;

import cn.red.offer.CopyOfComplexList;

class ComplexListNode {
	int val;
	ComplexListNode next;
	ComplexListNode sibling;
	
	public ComplexListNode() {}
	
	public ComplexListNode(int val) {
		this.val = val;
	}
}

public class Problem35 {
	
		
		public static void main(String[] args) {
			ComplexListNode root = new ComplexListNode(1);
			ComplexListNode node1 = new ComplexListNode(2);
			ComplexListNode node2 = new ComplexListNode(3);
			ComplexListNode node3 = new ComplexListNode(4);
			ComplexListNode node4 = new ComplexListNode(5);
			
			root.next = node1;
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			
			
			root.sibling = node1;
			node1.sibling = root;
			node3.sibling = node1;
			
			Problem35 ccl = new Problem35();
			ComplexListNode node = ccl.reconnectNodes(root);
			while (node != null) {
				System.out.println(node.val);
				
			}
		}
		
		public ComplexListNode clone(ComplexListNode pHead) {
			cloneNodes(pHead);
			connectSiblingNodes(pHead);
			return reconnectNodes(pHead);
		}
		
		// 第一步：复制原始链表的任意结点N，并创建新的结点N'，再把N'链接到N的后面
		public void cloneNodes(ComplexListNode pHead) {
			ComplexListNode pNode = pHead;
			while (pNode != null) {
				ComplexListNode pCloned = new ComplexListNode();
				pCloned.val = pNode.val;
				pCloned.next = pNode.next;
				pCloned.sibling = null;
				
				pNode.next = pCloned;
				
				pNode = pCloned.next;
			}
		}
		
		// 第二步：如果N的sibling指向S，则N'的sibling指向S的下一结点S'
		public void connectSiblingNodes(ComplexListNode pHead) {
			ComplexListNode pNode = pHead;
			while (pNode != null) {
				ComplexListNode pCloned = pNode.next;
				if (pNode.sibling != null) {
					pCloned.sibling = pNode.sibling.next;
				}
				pNode = pCloned.next;
			}
		}
		
		// 第三步：将第二步中的链表分成两个链表，奇数结点表示原始链表，偶数结点表示复制后的链表
		public ComplexListNode reconnectNodes(ComplexListNode pHead) {
			ComplexListNode pNode = pHead;
			ComplexListNode pClonedHead = null;
			ComplexListNode pClonedNode = null;
			
			if (pNode != null) {
				pClonedHead = pNode.next;
				pClonedNode = pNode.next;
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
