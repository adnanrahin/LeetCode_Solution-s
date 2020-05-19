package binary_tree_post_order_traversal_145;

import java.util.ArrayList;
import java.util.List;

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

	public static List<Integer> postorderTraversal(TreeNode root) {

		if (root == null)
			new ArrayList<Integer>();

		return helper(root, new ArrayList<Integer>());

	}

	public static List<Integer> helper(TreeNode root, List<Integer> list) {

		if (root == null)
			return list;

		helper(root.left, list);
		helper(root.right, list);
		list.add(root.val);

		return list;

	}

}
