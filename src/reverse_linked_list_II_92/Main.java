package reverse_linked_list_II_92;

public class Main {

}

//  Definition for singly-linked list.
class ListNode {
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

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode temp = head;

        int counter = 0;

        ListNode res = new ListNode();
        res = res.next;
        ListNode rev = temp;
        while (temp != null) {

            if (counter == m - 2) {
                rev = temp;
            }

            if (counter == m - 1) {

                while (counter < n) {
                    ListNode dummy = new ListNode(temp.val);
                    dummy.next = res;
                    res = dummy;
                    counter++;
                    temp = temp.next;
                }

                rev.next = res;

                while (rev.next != null) {
                    rev = rev.next;
                }
                rev.next = temp;
                if (m == 1)
                    return head.next;
                else return head;
            }
            counter++;
            temp = temp.next;

        }
        if (m == 1)
            return head.next;
        else return head;
    }
}


