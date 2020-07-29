package rotate_list_61;


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


    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) return head;

        int listNodeLen = getListNodeLength(head);

        k %= listNodeLen;

        ListNode restOfTheNodes = new ListNode();

        ListNode temp = head;

        int len = listNodeLen - k;

        while (len >= 0) {
            if (len == 0) {
                restOfTheNodes.next = temp.next;
                temp.next = null;
            }
            temp = temp.next;
            len--;
        }

        ListNode sol = restOfTheNodes.next;

        while (restOfTheNodes.next != null) {
            restOfTheNodes = restOfTheNodes.next;
        }
        restOfTheNodes.next = head;

        return sol;
    }

    public int getListNodeLength(ListNode head) {

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

}
