package find_bottom_left_tree_value_513;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

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

	// Test Case 1: [1,2,3,4,null,5,6,null,null,7]
	// Test Case 2: [0, null, -1]

	List<ValueData> list;

	public int findBottomLeftValue(TreeNode root) {

		if (root == null)
			return 0;

		if (root != null && (root.left == null && root.right == null))
			return root.val;

		list = new ArrayList<ValueData>();

		height(root, true, 0);

		int heighttemp = 0;
		int datatemp = 0;

		for (int i = 0; i < list.size(); i++) {
			if (heighttemp < list.get(i).height) {
				heighttemp = list.get(i).height;
				datatemp = list.get(i).data;
			}
		}

		return datatemp;

	}

	public void height(TreeNode root, boolean temp, int level) {
		if (root == null)
			return;

		list.add(new ValueData(root.val, level));

		height(root.left, true, level + 1);
		height(root.right, false, level + 1);

		return;
	}

	public static class ValueData {
		int data;
		int height;

		public ValueData(int data, int height) {

			this.data = data;
			this.height = height;

		}
	}

}
