package average_of_levels_in_binary_tree_637;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String args[]) {

	}

	class Solution {
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}

		public List<Double> averageOfLevels(TreeNode root) {

			List<Double> average = new ArrayList<Double>();
			Queue<TreeNode> q = new LinkedList<>();
			List<Long> list = new LinkedList<>();

			if (root == null)
				return average;

			q.add(root);

			while (!q.isEmpty()) {

				list = new LinkedList<Long>();

				int size = q.size();

				for (int i = 0; i < size; i++) {
					TreeNode u = q.peek();
					q.remove();
					list.add((long) u.val);
					if (u.left != null) {
						q.add(u.left);
					}
					if (u.right != null) {
						q.add(u.right);
					}
				}

				long sum = 0;

				for (int i = 0; i < list.size(); i++)
					sum += list.get(i);
				average.add(sum / (double) list.size());
			}

			return average;
		}
	}
}
