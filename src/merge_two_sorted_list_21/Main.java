package merge_two_sorted_list_21;

public class Main {

	public static void main(String args[]) {

		LinkedList temp = new LinkedList();
		temp.push(10);
		temp.push(20);
		temp.push(30);
		temp.push(40);
		temp.push(50);
		temp.print();

		LinkedList temp2 = new LinkedList();

		temp2.push(9);
		temp2.push(10);
		temp2.push(20);
		temp2.push(21);
		temp2.push(22);
		temp2.push(30);
		temp2.print();

		LinkedList mergerList = new LinkedList();

		mergerList.mergeTwoLists(temp.head, temp2.head);

		mergerList.print();

	}

	public static class LinkedList {

		public class ListNode {
			int val;
			ListNode next;

			public ListNode(int data) {
				this.val = data;
				next = null;
			}
		}

		public void push(int data) {

			if (head == null) {
				head = new ListNode(data);
				tail = head;
				return;
			}
			ListNode newNode = new ListNode(data);
			tail.next = newNode;
			tail = tail.next;
		}

		ListNode head = null;
		ListNode tail = null;

		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

			if (l1 == null && l2 == null)
				return null;
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;

			ListNode mergeNodehead = new ListNode(0);
			ListNode mergeNodetail = mergeNodehead;
			while (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					ListNode newNode = new ListNode(l2.val);
					mergeNodetail.next = newNode;
					mergeNodetail = mergeNodetail.next;
					l2 = l2.next;

				} else if (l1.val < l2.val) {
					ListNode newNode = new ListNode(l1.val);
					mergeNodetail.next = newNode;
					mergeNodetail = mergeNodetail.next;
					l1 = l1.next;
				} else if (l1.val == l2.val) {

					ListNode newNode1 = new ListNode(l2.val);
					mergeNodetail.next = newNode1;
					mergeNodetail = mergeNodetail.next;

					ListNode newNode2 = new ListNode(l1.val);
					mergeNodetail.next = newNode2;
					mergeNodetail = mergeNodetail.next;

					l1 = l1.next;
					l2 = l2.next;
				}
			}

			if (l1 == null) {
				while (l2 != null) {
					ListNode newNode = new ListNode(l2.val);
					mergeNodetail.next = newNode;
					mergeNodetail = mergeNodetail.next;
					l2 = l2.next;
				}
			}
			if (l2 == null) {
				while (l1 != null) {
					ListNode newNode = new ListNode(l1.val);
					mergeNodetail.next = newNode;
					mergeNodetail = mergeNodetail.next;
					l1 = l1.next;
				}
			}

			mergeNodehead = mergeNodehead.next;
			return mergeNodehead;
		}

		public void print() {

			ListNode newNode = head;

			while (newNode != null) {
				System.out.println(newNode.val);
				newNode = newNode.next;
			}

		}

	}

}
