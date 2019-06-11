package sum_of_left_leaves_404;

public class Main {

	public static void main(String[] args) {

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		static int total = 0;

		public static int sumOfLeftLeaves(TreeNode root) {

			total = 0;

			if (root == null)
				return 0;

			sum(root);

			return total;
		}

		public static void sum(TreeNode root) {

			if (root == null)
				return;
			if (isleaves(root.left))
				total += root.left.val;
			sum(root.left);
			sum(root.right);

		}

		public static boolean isleaves(TreeNode root) {

			if (root == null)
				return false;
			if (root.left == null && root.right == null)
				return true;
			return false;
		}
	}
}
