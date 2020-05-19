package palindrom_linked_list_234;

public class Main {

	public static void main(String args[]) {

	}

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {

		ListNode temp = head;
		ListNode hand = head;
		ListNode newNode = reverseList(temp);

		while (hand != null && newNode != null) {

			if (hand.val != newNode.val)
				return false;

			hand = hand.next;
			newNode = newNode.next;

		}

		return true;

	}

	ListNode head = null;
	ListNode tail = null;

	public ListNode push_back(int data, ListNode head) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;

		return head;
	}

	public ListNode reverseList(ListNode head) {

		ListNode reverseNode = null;

		while (head != null) {
			reverseNode = push_back(head.val, reverseNode);
			head = head.next;
		}
		return reverseNode;
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

}
