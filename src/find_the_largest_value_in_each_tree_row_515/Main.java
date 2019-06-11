package find_the_largest_value_in_each_tree_row_515;

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

	public List<Integer> largestValues(TreeNode root) {

		if (root == null)
			return new ArrayList<Integer>();

		return levelOrder(root);

	}

	public List<Integer> levelOrder(TreeNode root) {

		List<Integer> ans = new LinkedList<>();

		Queue<TreeNode> q = new LinkedList<>();

		List<Integer> list = new LinkedList<>();

		if (root == null)
			return ans;

		q.add(root);

		while (!q.isEmpty()) {

			list = new LinkedList<Integer>();

			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode u = q.peek();
				q.remove();
				list.add(u.val);
				if (u.left != null) {
					q.add(u.left);
				}
				if (u.right != null) {
					q.add(u.right);
				}
			}

			int temp = list.get(0);
			for (int i = 0; i < list.size(); i++) {
				if (temp < list.get(i))
					temp = list.get(i);
			}

			ans.add(temp);

		}
		return ans;
	}

}
