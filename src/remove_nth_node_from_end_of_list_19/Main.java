package remove_nth_node_from_end_of_list_19;

public class Main {

	public static void main(String args[]) {


	}

	public static class LList {

		public class ListNode {
			int val;
			ListNode next;

			public ListNode(int data) {
				this.val = data;
			}

		}

		public ListNode removeNthFromEnd(ListNode head, int n) {

			int len = 0;
			ListNode temp = null;
			temp = head;
			while (temp != null) {
				len++;
				temp = temp.next;
			}

			ListNode myNodeHead = null;
			ListNode myNodeTail = null;

			if (len == 1)
				return null;
			if (len - n == 0)
				return head.next;

			temp = head;

			if (n == len) {
				while (temp.next != null) {
					if (myNodeHead == null) {
						myNodeHead = new ListNode(temp.val);
						myNodeTail = myNodeHead;
						myNodeTail.next = null;
					} else {
						myNodeTail.next = new ListNode(temp.val);
						myNodeTail = myNodeTail.next;
					}
					temp = temp.next;
				}
				return myNodeHead;
			}

			int counter = 0;

			while (counter < len - n) {
				counter++;
				if (myNodeHead == null) {
					myNodeHead = new ListNode(temp.val);
					myNodeTail = myNodeHead;
					myNodeTail.next = null;
				} else if (myNodeHead != null) {
					myNodeTail.next = new ListNode(temp.val);
					myNodeTail = myNodeTail.next;
				}
				temp = temp.next;
			}

			myNodeTail.next = temp.next;
			myNodeTail = myNodeTail.next;

			temp = myNodeHead;
			while (temp != null) {
				System.out.println(temp.val);
				temp = temp.next;
			}

			return myNodeHead;

		}

	}

}
