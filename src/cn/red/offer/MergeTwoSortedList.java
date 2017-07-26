package cn.red.offer;

class ListNode4 {
	int val;
	ListNode4 next;
	ListNode4(int val) {
		this.val = val;
	}
}

public class MergeTwoSortedList {

	public static void main(String[] args) {
		ListNode4 head1 = new ListNode4(1);
		ListNode4 second1 = new ListNode4(3);
		ListNode4 head2 = new ListNode4(2);
		ListNode4 second2 = new ListNode4(2);
		ListNode4 third2 = new ListNode4(2);
		
		head1.next = second1;
		head2.next = second2;
		second2.next = third2;
		
		MergeTwoSortedList mtsl = new MergeTwoSortedList();
		ListNode4 merge = mtsl.Merge(null, null);
		System.out.println(merge.val);
	}

	public ListNode4 Merge(ListNode4 list1, ListNode4 list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		
		ListNode4 mergeHead = null;
		if (list1.val < list2.val) {
			mergeHead = list1;
			mergeHead.next = Merge(list1.next, list2);
		} else {
			mergeHead = list2;
			mergeHead.next = Merge(list1, list2.next);
		}
		return mergeHead;
	}

}
