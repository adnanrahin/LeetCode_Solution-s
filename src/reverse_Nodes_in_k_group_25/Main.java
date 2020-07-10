package reverse_Nodes_in_k_group_25;

public class Main {

    public static void main(String[] args) {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }
        ListNode reverseNode = reverse(head, temp);

        head.next = reverseKGroup(temp, k);

        return reverseNode;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode headOfTailNode = tail;
        while (head != tail) {
            ListNode temp = head.next;
            head.next = headOfTailNode;
            headOfTailNode = head;
            head = temp;
        }
        return headOfTailNode;
    }

}
