package reverse_linked_list_206;

public class Main {

	public static void main(String args[]) {

		LinkedList temp = new LinkedList();
		temp.push(10);
		temp.push(20);
		temp.push(30);
		temp.push(40);
		temp.push(50);

		temp.print();

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

		public ListNode push_back(int data,ListNode head) {
			ListNode newNode = new ListNode(data);
			newNode.next = head;
			head = newNode;
			
			return head;
		}
		
		public ListNode reverseList(ListNode head) {

			ListNode reverseNode = null;
			
			while(head!=null) {
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

		public void print() {

			ListNode newNode = head;

			while (newNode != null) {
				System.out.println(newNode.val);
				newNode = newNode.next;
			}

		}

	}

}
