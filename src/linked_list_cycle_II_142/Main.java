package linked_list_cycle_II_142;

public class Main {

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode newNode = head;
                while (newNode != slow) {
                    newNode = newNode.next;
                    slow = slow.next;
                }
                return newNode;
            }
        }

        return null;
    }
}