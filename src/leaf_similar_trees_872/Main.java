package leaf_similar_trees_872;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		list1 = helper(root1, list1);
		list2 = helper(root2, list2);

		return list1.equals(list2);

	}

	public List<Integer> helper(TreeNode root, List<Integer> list) {

		if (root == null) {
			return list;
		}

		if (root.left == null && root.right == null) {
			list.add(root.val);
			return list;
		}

		helper(root.left, list);
		helper(root.right, list);

		return list;

	}

}
