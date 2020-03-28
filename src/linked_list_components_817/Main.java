package linked_list_components_817;

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
        }
    }

    class Solution {

        public int numComponents(ListNode head, int[] G) {

            int numberOfComponents = 0;

            Set<Integer> set = new HashSet<>();

            for (int e : G) set.add(e);

            int local = 0;

            while (head != null) {

                if (set.contains(head.val)) {
                    local++;
                } else {
                    if (local > 0) {
                        numberOfComponents++;
                    }
                    local = 0;
                }
                head = head.next;
            }

            if(local > 0) numberOfComponents++;

            return numberOfComponents;

        }

    }


}
