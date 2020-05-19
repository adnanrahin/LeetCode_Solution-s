package add_one_row_to_tree_623;

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

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }

        return insert(v, root, 1, d);
    }

    public TreeNode insert(int val, TreeNode root, int depth, int currentLevel) {
        if (root == null)
            return null;
        if (depth == currentLevel - 1) {
            TreeNode t = root.left;
            root.left = new TreeNode(val);
            root.left.left = t;
            t = root.right;
            root.right = new TreeNode(val);
            root.right.right = t;
        } else {
            insert(val, root.left, depth + 1, currentLevel);
            insert(val, root.right, depth + 1, currentLevel);
        }

        return root;
    }

}
