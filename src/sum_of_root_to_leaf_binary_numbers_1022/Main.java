package sum_of_root_to_leaf_binary_numbers_1022;

public class Main {

	public static void main(String args[]) {

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public int sumRootToLeaf(TreeNode root) {
		int nodesum = 0;
		String str = new String();
		return preOrder(root, str, nodesum);
	}

	public int preOrder(TreeNode root, String str, int nodesum) {

		if (root == null) {
			return 0;
		}
		str += Integer.toString(root.val);

		if (root.left == null && root.right == null) {
			return nodesum = nodesum + Integer.parseInt(str, 2);
		}

		return preOrder(root.right, str, nodesum) + preOrder(root.left, str, nodesum);

	}

}
