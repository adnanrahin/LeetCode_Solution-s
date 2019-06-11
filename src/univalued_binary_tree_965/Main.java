package univalued_binary_tree_965;

import java.util.HashSet;
import java.util.Set;

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

	public boolean isUnivalTree(TreeNode root) {

		Set<Integer> set = new HashSet<Integer>();
		
		set = helper(root, set);
		
		return (set.size() == 1);

	}

	public static Set<Integer> helper(TreeNode root, Set<Integer> set) {
		if (root == null)
			return set;

		set.add(root.val);

		helper(root.left, set);
		helper(root.right, set);

		return set;

	}

}
