package subtree_of_another_tree_572;

public class Main {

    public static void main(String args[]) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return (helper(s, t) || (s != null && ((isSubtree(s.left, t)) || isSubtree(s.right, t))));
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if ((s == null && t != null) || (s != null && t == null))
            return false;

        if (s != null && t != null && s.val == t.val || !helper(s.right, t.right) || !helper(s.left, t.left))
            return false;

        return true;
    }

}
