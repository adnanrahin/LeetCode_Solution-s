package delete_leaves_with_a_given_value_1325;

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

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        root = helper(root, target);

        return root;
    }

    public TreeNode helper(TreeNode root, int target) {

        if (root == null)
            return null;

        if (root.left != null)
            root.left = helper(root.left, target);

        if (root.right != null)
            root.right = helper(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;

    }

}
