package find_bottom_left_tree_value_513;

public class Main {

    public static void main(String args[]) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Integer val = null;

    public int findBottomLeftValue(TreeNode root) {
        int getLevel = getHeight(root);
        findBottomLeft(root, getLevel, 0);
        return val;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public void findBottomLeft(TreeNode root, int level, int curLevel) {
        if (root == null) return;
        if (curLevel == level - 1 && val == null) {
            val = root.val;
        }
        findBottomLeft(root.left, level, curLevel + 1);
        findBottomLeft(root.right, level, curLevel + 1);
    }

}
