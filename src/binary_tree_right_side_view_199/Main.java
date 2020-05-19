package binary_tree_right_side_view_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public static List<Integer> rightSideView(TreeNode root) {

		return helper(root, new ArrayList<Integer>());
	}

	public static List<Integer> helper(TreeNode root, List<Integer> ans) {

		if (root == null)
			return ans;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		queue.add(root);

		while (!queue.isEmpty()) {

			list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode u = queue.peek();
				queue.remove();
				list.add(u.val);
				if (u.left != null) {
					queue.add(u.left);
				}
				if (u.right != null) {
					queue.add(u.right);
				}
			}

			ans.add(list.get(list.size() - 1));
		}
		return ans;

	}

}
