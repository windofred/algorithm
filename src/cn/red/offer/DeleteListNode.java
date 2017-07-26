package cn.red.offer;

class ListNode {
	int data;
	ListNode next;
}

public class DeleteListNode {
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		
		head.next = second;
		second.next = third;
		
		head.data = 1;
		second.data = 2;
		third.data = 3;
		
		DeleteListNode dln = new DeleteListNode();
		dln.deleteNode(head, second);
		System.out.println(second.next.data);
	}
	
	public void deleteNode(ListNode head, ListNode deListNode) {
		if(deListNode == null || head == null){
			return ;
		}
		if(head == deListNode){
			head =null;
		}
		else{
			if(deListNode.next == null){
				ListNode pinitListNode = head;
				while(pinitListNode.next.next != null){
					pinitListNode = pinitListNode.next;
				}
				pinitListNode.next = null;
			}else{
				deListNode.data = deListNode.next.data;
				deListNode.next = deListNode.next.next;
			}
		}
		
		
	}
	
}
