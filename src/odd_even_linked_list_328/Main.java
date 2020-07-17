package odd_even_linked_list_328;

public class Main {
    public static void main(String[] args) {

    }

    static class ListNode {
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

    static class Solution {
        public ListNode oddEvenList(ListNode head) {

            if (head == null) return head;

            ListNode oddPtr = head;
            ListNode evenPtr = head.next;
            ListNode even = evenPtr;

            while (evenPtr != null && evenPtr.next != null) {
                oddPtr.next = evenPtr.next;
                oddPtr = oddPtr.next;
                evenPtr.next = oddPtr.next;
                evenPtr = even.next;
            }
            oddPtr.next = even;
            return head;
        }
    }

}


