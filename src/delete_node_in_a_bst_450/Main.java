package delete_node_in_a_bst_450;

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

	public static int minValue(TreeNode root) {
		if (root.left == null)
			return root.val;
		return minValue(root.left);
	}

	public static TreeNode deleteNode(TreeNode root, int key) {

		if (root == null)
			return root;

		if (root.val > key)
			root.left = deleteNode(root.left, key);
		else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.val = minValue(root.right);
			root.right = deleteNode(root.right, root.val);

		}

		return root;
	}

}
