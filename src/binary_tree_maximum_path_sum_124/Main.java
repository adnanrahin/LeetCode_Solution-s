package binary_tree_maximum_path_sum_124;

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

    int maxSum;

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        maxSum = maxSumFinder(root);

        return maxSum;
    }

    public int maxSumFinder(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, maxSumFinder(root.left));
        int right = Math.max(0, maxSumFinder(root.right));
        maxSum = Math.max(maxSum, root.val + right + left);

        return Math.max(left, right) + root.val;
    }

}
