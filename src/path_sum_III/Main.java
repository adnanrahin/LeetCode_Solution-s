package path_sum_III;

public class Main {

    public static void main(String args[]) {

    }


    public class TreeNode {
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

    class Solution {

        int counter;

        public int pathSum(TreeNode root, int sum) {
            counter = 0;
            helper(root, sum);
            return counter;
        }

        public void helper(TreeNode root, int sum) {
            if (root == null) return;
            getTotalPathSum(root, sum);
            helper(root.left, sum);
            helper(root.right, sum);
        }

        public void getTotalPathSum(TreeNode root, int sum) {
            if (root == null) return;
            if (root.val == sum) {
                System.out.println(root.val);
                counter++;
                return;
            }
            getTotalPathSum(root.left, sum - root.val);
            getTotalPathSum(root.right, sum - root.val);
        }

    }

}
