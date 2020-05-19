package remove_duplicates_from_sorted_list_II_82;

import java.util.HashMap;

public class Main {

	public static void main(String args[]) {

	}

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int data) {
			this.val = data;
			next = null;
			
		}
	}

	public ListNode deleteDuplicates(ListNode head) {

		ListNode temp = head;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (temp != null) {

			if (map.containsKey(temp.val))
				map.put(temp.val, map.get(temp.val) + 1);
			else
				map.put(temp.val, 1);
			temp = temp.next;
		}

		temp = head;

		head = null;
		ListNode tail = null;

		head = new ListNode(0);
		tail = head;
		while (temp != null) {
			if (map.containsKey(temp.val) && map.get(temp.val) == 1) {
				ListNode newNode = new ListNode(temp.val);
				tail.next = newNode;
				tail = tail.next;
			}
			temp = temp.next;
		}

		return head.next;
	}

}
