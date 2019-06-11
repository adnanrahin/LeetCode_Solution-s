package construct_a_binary_search_tree_from_preorder_traversal_1008;

public class Main {

	public static void main(String args[]) {

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode bstFromPreorder(int[] preorder) {

		if (preorder.length == 0)
			return null;

		TreeNode rooTreeNode = new TreeNode(preorder[0]);

		for (int i = 1; i < preorder.length; i++) {
			rooTreeNode = BST(rooTreeNode, preorder[i]);
		}

		return rooTreeNode;
	}

	public static TreeNode BST(TreeNode root, int data) {

		if (root == null) {
			root = new TreeNode(data);
			return root;
		} else {
			if (root.val < data)
				root.right = BST(root.right, data);
			else
				root.left = BST(root.left, data);
		}

		return root;
	}

}
