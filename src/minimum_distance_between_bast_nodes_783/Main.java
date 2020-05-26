package minimum_distance_between_bast_nodes_783;

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

	public static int minDiffInBST(TreeNode root) {
		if (root == null)
			return 0;

		List<Integer> list = new ArrayList<Integer>();

		list = helper(root, list);

		int mindiff = list.get(list.size() - 1);

		for (int i = 0; i < list.size() - 1; i++) {
			mindiff = Math.min(mindiff, list.get(i + 1) - list.get(i));
		}

		return mindiff;
	}

	public static List<Integer> helper(TreeNode root, List<Integer> list) {

		if (root == null)
			return list;

		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list);

		return list;
	}

}
