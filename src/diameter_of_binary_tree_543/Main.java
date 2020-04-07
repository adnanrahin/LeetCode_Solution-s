package diameter_of_binary_tree_543;

public class Main {

    public static void main(String args[]) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        return Math.max(height(root.left) + height(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}
