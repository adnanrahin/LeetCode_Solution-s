package path_sum_II_113;

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

	static List<List<Integer>> answer;

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<Integer> list = new ArrayList<Integer>();

		answer = new ArrayList<List<Integer>>();
		if (root == null)
			return answer;
		helper(root, sum, list);

		return answer;
	}

	public static void helper(TreeNode root, int sum, List<Integer> list) {
		list.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			answer.add(new ArrayList<Integer>(list));
		}
		if (root.left != null) {
			helper(root.left, sum - root.val, list);
		}
		if (root.right != null) {
			helper(root.right, sum - root.val, list);
		}
		list.remove(list.size() - 1);
	}

}
