package convert_binary_number_in_a_linked_list_to_integer_1290;

public class Main {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int getDecimalValue(ListNode head) {

        ListNode temp = head;

        int listLength = 0;

        while (temp != null) {
            listLength++;
            temp = temp.next;
        }

        temp = head;
        int decimalNumber = 0;

        while (temp != head) {
            decimalNumber += Math.pow(2, --listLength) * temp.val;
            temp = temp.next;
        }

        return decimalNumber;
    }

}
