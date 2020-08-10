package insertion_sort_list_147;

public class Main {

    public static void main(String args[]) {

    }

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

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode p, solution = new ListNode(0), temp = head;

        solution.next = head;

        while (temp.next != null) {

            if (temp.val > temp.next.val) {
                p = solution;
                while (p.next != null && p.next.val < temp.next.val) {
                    p = p.next;
                }
                ListNode nextNode = temp.next.next;
                temp.next.next = p.next;
                p.next = temp.next;
                temp.next = nextNode;

            } else temp = temp.next;

        }

        return solution.next;
    }
}
