package rotate_list_61;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int data) {
			this.val = data;
			next = null;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null)
			return null;

		ListNode newNode = head;

		List<Integer> list = new ArrayList<Integer>();

		while (newNode != null) {
			list.add(newNode.val);
			newNode = newNode.next;
		}

		for (int i = 0; i < k % list.size(); i++) {

			int temp = list.get(list.size() - 1);

			for (int j = list.size() - 1; j > 0; j--) {
				list.set(j, list.get(j - 1));
			}
			list.set(0, temp);

		}

		newNode = head;

		for (int i = 0; i < list.size(); i++) {

			newNode = new ListNode(list.get(i));
			newNode = newNode.next;

		}

		return head.next;

	}

}
