package invert_binary_tree_226;

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

	public static TreeNode invertTree(TreeNode root) {

		if (root != null) {

			TreeNode leftPointer = root.left;
			root.left = root.right;
			root.right = leftPointer;

			invertTree(root.left);
			invertTree(root.right);
		}

		return root;

	}

}
