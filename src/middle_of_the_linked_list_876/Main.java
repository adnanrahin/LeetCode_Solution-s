package middle_of_the_linked_list_876;

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

		public ListNode middleNode(ListNode head) {

			ListNode faster = head;
			ListNode slower = head;

			while (faster != null && faster.next != null) {
				faster = faster.next.next;
				slower = slower.next;
			}
			return slower;

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
