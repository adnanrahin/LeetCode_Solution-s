package insertion_sort_list_147;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {

		ListNode newNode = head;

		List<Integer> list = new ArrayList<Integer>();

		while (newNode != null) {
			list.add(newNode.val);
			newNode = newNode.next;
		}

		for (int i = 1; i < list.size(); i++) {
			int j = i;

			while (j > 0 && list.get(j - 1) > list.get(j)) {
				int n = list.get(j - 1);
				list.set(j - 1, list.get(j));
				list.set(j, n);
				j--;
			}

		}

		newNode = head;

		for (int i = 0; i < list.size(); i++) {
			head.val = list.get(i);
			head = head.next;
		}

		return newNode;
	}
}
