package reorder_list_143;

import java.util.Deque;
import java.util.LinkedList;

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

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return;

        ListNode outer = head;

        while (outer.next != null && outer.next.next != null) {
            ListNode temp = outer;

            ListNode cur = outer.next;
            while (temp.next.next != null) {
                temp = temp.next;
            }

            outer.next = temp.next;
            temp.next = null;
            outer.next.next = cur;
            outer = outer.next.next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            ListNode temp = head;

            Deque<ListNode> deque = new LinkedList<>();

            while (temp != null) {
                ListNode prev = temp;
                deque.add(temp);
                temp = temp.next;
                prev.next = null;
            }

            while (!deque.isEmpty()) {
                head.next = deque.removeFirst();
                head = head.next;
                if (!deque.isEmpty()) {
                    head.next = deque.removeLast();
                    head = head.next;
                }
            }

        }
    }

}
