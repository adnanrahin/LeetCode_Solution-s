package binary_tree_level_order_traversal_II_107;

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

		public List<List<Integer>> levelOrderBottom(TreeNode root) {

			List<List<Integer>> ans = new LinkedList<>();

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

				ans.add(list);
			}
			
			Collections.reverse(ans);
			
			return ans;
		}
	}
}
