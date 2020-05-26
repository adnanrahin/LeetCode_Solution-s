package remove_zero_sum_consecutive_nodes_from_linked_list_1171;

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

    public static ListNode removeZeroSumSublists(ListNode head) {

        ListNode Head = new ListNode(0);
        Head.next = head;
        ListNode cur = Head;
        while (cur != null) {
            int sum = 0;
            while (head != null) {
                sum += head.val;
                if (sum == 0) {
                    cur.next = head.next;
                }
                head = head.next;
            }
            cur = cur.next;
            if (cur != null) {
                head = cur.next;
            }
        }
        return Head.next;
    }

}
