package two_sum_IV_653;

import java.util.HashSet;
import java.util.Set;

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

	public static boolean findTarget(TreeNode root, int k) {

		if (root == null) {
			return false;
		}

		Set<Integer> sets = new HashSet<Integer>();

		return helper(root, k, sets);
	}

	public static boolean helper(TreeNode root, int target, Set<Integer> sets) {

		if (root == null)
			return false;

		if (sets.contains(target - root.val))
			return true;

		sets.add(root.val);

		return (helper(root.left, target, sets) || helper(root.right, target, sets));

	}

}
