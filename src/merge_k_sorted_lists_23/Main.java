package merge_k_sorted_lists_23;

public class Main {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return new ListNode(0).next;
		
		return mergeListNode(lists, 0, lists.length - 1);
	}

	public static ListNode mergeListNode(ListNode[] lists, int left, int right) {
		
		if(left < right) {
			int mid = (left + right) / 2;
			return merge(mergeListNode(lists, left, mid), mergeListNode(lists, mid + 1, right));
		}
		return lists[left];
	}
	
	public static ListNode merge(ListNode l1, ListNode l2) {

		ListNode temp = new ListNode(0);
		ListNode tail = temp;

		if (l1 == null && l2 != null)
			return l2;
		if (l2 == null && l1 != null)
			return l1;

		if (l1 == null && l2 == null)
			return new ListNode(0).next;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				ListNode newNode = new ListNode(l1.val);
				tail.next = newNode;
				tail = tail.next;
				l1 = l1.next;
			}

			else if (l1.val > l2.val) {
				ListNode newNode = new ListNode(l2.val);
				tail.next = newNode;
				tail = tail.next;
				l2 = l2.next;
			}

			else {
				ListNode newNode = new ListNode(l2.val);
				tail.next = newNode;
				tail = tail.next;
				ListNode newNode2 = new ListNode(l1.val);
				tail.next = newNode2;
				tail = tail.next;
				l1 = l1.next;
				l2 = l2.next;
			}
		}

		if (l1 == null) {
			while (l2 != null) {
				ListNode newNode = new ListNode(l2.val);
				tail.next = newNode;
				tail = tail.next;
				l2 = l2.next;
			}
		}

		if (l2 == null) {
			while (l1 != null) {
				ListNode newNode = new ListNode(l1.val);
				tail.next = newNode;
				tail = tail.next;
				l1 = l1.next;
			}
		}

		return temp.next;
	}

}
