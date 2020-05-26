package sort_list_148;

public class Main {

    public static void main(String args[]) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode sec_head = slow.next;
        slow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(sec_head);

        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        if (l1 == null && l2 != null)
            return l2;
        if (l2 == null && l1 != null)
            return l1;

        if (l1 == null && l2 == null)
            return new ListNode(0).next;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                ListNode newNode = new ListNode(l1.val);
                tail.next = newNode;
                tail = tail.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                ListNode newNode = new ListNode(l2.val);
                tail.next = newNode;
                tail = tail.next;
                l2 = l2.next;
            } else {
                ListNode newNode = new ListNode(l2.val);
                tail.next = newNode;
                tail = tail.next;
                ListNode newNode2 = new ListNode(l1.val);
                tail.next = newNode2;
                tail = tail.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            while (l2 != null) {
                ListNode newNode = new ListNode(l2.val);
                tail.next = newNode;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if (l2 == null) {
            while (l1 != null) {
                ListNode newNode = new ListNode(l1.val);
                tail.next = newNode;
                tail = tail.next;
                l1 = l1.next;
            }
        }

        return temp.next;
    }

}
