package intersection_of_two_linked_lists_160;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> setA = new HashSet<>();

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            setA.add(tempA);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (setA.contains(tempB))
                return tempB;
            tempB = tempB.next;
        }
        return null;
    }

}
