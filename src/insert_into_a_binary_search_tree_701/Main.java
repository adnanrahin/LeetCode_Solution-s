package insert_into_a_binary_search_tree_701;

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else
            root.left = insertIntoBST(root.left, val);

        return root;
    }

}
