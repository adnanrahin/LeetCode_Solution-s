package remove_linked_list_elements_203;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);

        removeElements(node, 6);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null) {
            if (temp.val != val)
                list.add(temp.val);

            temp = temp.next;
        }

        temp = new ListNode(0);
        head = temp;

        for (int i = 0; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));

            temp = temp.next;
        }

        return head.next;
    }

}
