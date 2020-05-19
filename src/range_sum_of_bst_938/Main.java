package range_sum_of_bst_938;

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

    static int sum;

    public static int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null)
            return 0;

        sum = 0;

        getSum(root, L, R);

        return sum;
    }

    public static void getSum(TreeNode root, int L, int R) {

        if (root == null)
            return;

        if ((root.val < L || root.val > R))
            sum+=0;

        sum += root.val;

        getSum(root.left, L, R);
        getSum(root.right, L, R);

        return;

    }

}
