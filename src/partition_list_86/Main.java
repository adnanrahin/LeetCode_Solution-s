package partition_list_86;

public class Main {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode frontPtr = new ListNode();
            ListNode front = frontPtr;
            ListNode backPtr = new ListNode();
            ListNode back = backPtr;

            while (head != null) {

                if (head.val < x) {
                    backPtr.next = new ListNode(head.val);
                    backPtr = backPtr.next;
                } else {
                    frontPtr.next = new ListNode(head.val);
                    frontPtr = front.next;
                }
                head = head.next;
            }
            frontPtr.next = null;
            backPtr.next = front.next;

            return back.next;

        }
    }

}
