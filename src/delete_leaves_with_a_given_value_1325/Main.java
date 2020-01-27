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

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        if (root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        return root;

    }
}
