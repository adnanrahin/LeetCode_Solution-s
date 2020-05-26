package linked_list_in_binary_tree_1367;

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

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (head == null) return true;

        if (root == null) return false;

        return depthFirstSearch(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean depthFirstSearch(ListNode head, TreeNode root) {

        if (head == null) return true;

        if (root == null) return false;

        return (root.val == head.val) && (depthFirstSearch(head.next, root.left) || depthFirstSearch(head.next, root.right));

    }

}
