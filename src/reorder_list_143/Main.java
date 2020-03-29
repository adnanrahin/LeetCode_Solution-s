package reorder_list_143;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        for (int i = 0; i < list.size(); i++) {
            
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null)return;

        ListNode outer = head;

        while(outer.next!=null && outer.next.next!=null){
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

}
