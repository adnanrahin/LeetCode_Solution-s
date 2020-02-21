package search_in_binary_search_tree_700;

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

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;

        if (root.val == val) {
            return root;
        }

        if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

}
