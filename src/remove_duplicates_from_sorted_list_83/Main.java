package remove_duplicates_from_sorted_list_83;

public class Main {

	public static void main(String args[]) {

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

		ListNode head = null;
		ListNode tail = null;

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

		public ListNode deleteDuplicates(ListNode head) {

			ListNode newNodeHead = head;
			
			while(newNodeHead!=null && newNodeHead.next!=null) {
				if(newNodeHead.val == newNodeHead.next.val) {
					newNodeHead.next = newNodeHead.next.next;
				} else newNodeHead = newNodeHead.next;
			}
			
			return newNodeHead;
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
