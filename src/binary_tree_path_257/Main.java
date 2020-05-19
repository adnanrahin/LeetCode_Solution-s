package binary_tree_path_257;

import java.util.ArrayList;
import java.util.List;

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

	public static List<String> binaryTreePaths(TreeNode root) {

		if (root == null)
			return new ArrayList<String>();

		List<String> path = new ArrayList<String>();
		String str = "";

		helper(root, str, path);

		return path;

	}

	public static void helper(TreeNode root, String str, List<String> path) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			str = str + Integer.toString(root.val);
			str.substring(0, str.length());
			path.add(str);
			return;
		}
		str = str + Integer.toString(root.val) + "->";

		helper(root.left, str, path);
		helper(root.right, str, path);

		return;
	}
}
