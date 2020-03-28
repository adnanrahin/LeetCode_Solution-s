package convert_sorted_list_to_binary_search_tree_109;

import java.util.ArrayList;
import java.util.List;

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        TreeNode root;

        public TreeNode sortedListToBST(ListNode head) {

            ListNode temp = head;

            List<Integer> list = listConverter(temp);

            divideAndConquer(list, 0, list.size());

            return root;
        }

        public void divideAndConquer(List<Integer> list, int left, int right) {

            if (left > right)
                return;
            int mid = (left + right) / 2;
            root = addTreeNode(root, list.get(mid));
            divideAndConquer(list, left, mid - 1);
            divideAndConquer(list, mid + 1, right);
            return;
        }

        public List<Integer> listConverter(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode temp = head;

            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
            return list;
        }

        public TreeNode addTreeNode(TreeNode root, int val) {

            if (root == null) {
                root = new TreeNode(val);
                return root;
            }

            if (root.val > val)
                root.left = addTreeNode(root.left, val);
            else if (root.val < val)
                root.right = addTreeNode(root.right, val);

            return root;
        }

    }

}
