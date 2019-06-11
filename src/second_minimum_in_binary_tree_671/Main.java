package second_minimum_in_binary_tree_671;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public static Set<Integer> list;

	public int findSecondMinimumValue(TreeNode root) {

		list = new HashSet<Integer>();
		helper(root);
		if (list.size() == 1)
			return -1;

		List<Integer> ans = new ArrayList<Integer>();

		for (Integer itr : list)
			ans.add(itr);

		return ans.get(1);
	}

	public static void helper(TreeNode root) {

		if (root == null)
			return;

		helper(root.left);
		list.add(root.val);
		helper(root.right);

		return;

	}

}
