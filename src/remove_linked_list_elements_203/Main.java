package remove_linked_list_elements_203;

public class Main {

    public static void main(String args[]) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);

        new Solution().removeElements(node, 6);

    }


    public static class ListNode {
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

    // Time Complexity O(n) and Space Complexity O(n)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode solution = new ListNode();
        ListNode solutionHead = solution;

        while (head != null) {
            if (head.val != val) {
                solution.next = new ListNode(head.val, solution.next);
                solution = solution.next;
            }
            head = head.next;
        }
        return solutionHead.next;
    }


    public static class Solution {

        // Time Complexity O(n) and Space Complexity O(1)

        public ListNode removeElements(ListNode head, int val) {

            while (head != null && head.val == val) {
                head = head.next;
            }

            ListNode prev = head;
            ListNode temp = head;

            while (temp != null) {
                if (temp.val == val) {
                    prev.next = temp.next;
                } else prev = temp;
                temp = temp.next;
            }

            return head;
        }
    }

}
