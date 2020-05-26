package symmetric_tree_101;

public class Main {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {

	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}

	private static boolean helper(TreeNode leftnode, TreeNode rightnode) {

		if (leftnode == null && rightnode == null)
			return true;

		if (leftnode != null && rightnode != null && leftnode.val == rightnode.val) {
			return (helper(leftnode.left, rightnode.right) && helper(leftnode.right, rightnode.left));
		}

		return false;
	}

}
