package maximum_level_sum_of_a_binary_tree_1161;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String args[]) {

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static int maxLevelSum(TreeNode root) {

		if (root == null)
			return 0;

		int maxSum = 0;
		int maximumLevel = 1;
		int level = 1;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while (!queue.isEmpty()) {
			
			level++;
			
			int size = queue.size();

			int sum = 0;

			for (int i = 0; i < size; i++) {

				TreeNode uNode = queue.peek();
				queue.remove();

				if (uNode.left != null) {
					queue.add(uNode.left);
					sum += uNode.left.val;
				}

				if (uNode.right != null) {
					queue.add(uNode.right);
					sum += uNode.right.val;
				}

			}
			if (maxSum < sum) {
				maxSum = sum;
				maximumLevel = level;
			}

		}
		return maximumLevel;

	}

}
