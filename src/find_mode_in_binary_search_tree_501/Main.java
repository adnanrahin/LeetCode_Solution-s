package find_mode_in_binary_search_tree_501;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Main {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int[] findMode(TreeNode root) {

		if (root == null)
			return new int[] {};
		Hashtable<Integer, Integer> tb = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> table = Helper(root, tb);

		int max = getMax(table);

		List<Integer> list = new ArrayList<Integer>();

		for (Map.Entry<Integer, Integer> itr : table.entrySet()) {
			if (itr.getValue() == max)
				list.add(itr.getKey());
		}
		int arr[] = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);

		return arr;
	}

	public static Hashtable<Integer, Integer> Helper(TreeNode root, Hashtable<Integer, Integer> table) {

		if (root == null)
			return table;

		if (table.containsKey(root.val)) {
			table.put(root.val, table.get(root.val) + 1);
		} else
			table.put(root.val, 1);

		Helper(root.left, table);
		Helper(root.right, table);

		return table;
	}

	public static int getMax(Hashtable<Integer, Integer> table) {

		int max = 0;

		for (Map.Entry<Integer, Integer> itr : table.entrySet()) {
			if (max < itr.getValue())
				max = itr.getValue();
		}

		return max;
	}

}
