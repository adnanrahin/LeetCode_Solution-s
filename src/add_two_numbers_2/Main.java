package add_two_numbers_2;

public class Main {

	public static void main(String args[]) {

	}

	public static class LinkedList {

		class ListNode {

			int val;
			ListNode next;

			ListNode(int data) {
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

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			if (l1 == null && l2 == null) {
				ListNode temp = new ListNode(0);
				return temp.next;
			}

			if (l1 != null && l2 == null) {
				return l1;
			}

			if (l2 != null && l1 == null)
				return l2;

			int carry = 0;

			ListNode temp = new ListNode(0);
			ListNode temptail = temp;
			while (l1 != null && l2 != null) {

				int add = l1.val + l2.val + carry;

				int mod = add % 10;

				carry = add / 10;

				ListNode newNode = new ListNode(mod);

				temptail.next = newNode;

				temptail = temptail.next;

				l1 = l1.next;
				l2 = l2.next;
			}

			if (l2 == null) {

				while (l1 != null) {
					int add = l1.val + carry;

					int mod = add % 10;

					carry = add / 10;
					ListNode newNode = new ListNode(mod);

					temptail.next = newNode;

					temptail = temptail.next;

					l1 = l1.next;
				}
			}
			if (l1 == null) {

				while (l2 != null) {
					int add = l2.val + carry;

					int mod = add % 10;

					carry = add / 10;
					ListNode newNode = new ListNode(mod);

					temptail.next = newNode;

					temptail = temptail.next;

					l2 = l2.next;
				}
			}

			if (carry != 0) {
				ListNode newNode = new ListNode(carry);

				temptail.next = newNode;

				temptail = temptail.next;
			}

			return temp.next;

		}
	}
}
