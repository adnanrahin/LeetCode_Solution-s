package flatten_binary_tree_linked_list_114;

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

	public void flatten(TreeNode root) {

		if (root == null || root.right == null && root.left == null)
			return;

		if (root.left != null) {

			flatten(root.left);

			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;

			TreeNode hand = root.right;

			while (hand.right != null) {
				hand = hand.right;
			}
			hand.right = temp;
		}

		flatten(root.right);
		
	}

}
