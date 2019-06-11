package smallest_string_starting_from_leaf_988;

import java.util.ArrayList;
import java.util.List;

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

	public static String smallestFromLeaf(TreeNode root) {

		if (root == null)
			return new String();

		List<String> list = new ArrayList<String>();

		helper(root, "", list);

		String str = list.get(0);

		System.out.println(list);

		for (int i = 1; i < list.size(); i++) {

			if (str.compareTo(list.get(i)) > 0) {
				str = list.get(i);
			}

		}
		return str;
	}

	public static void helper(TreeNode root, String str, List<String> list) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			char c = (char) (root.val + 97);
			str += Character.toString(c);
			list.add(reverseString(str));
			return;
		}
		char c = (char) (root.val + 97);
		str += Character.toString(c);

		helper(root.left, str, list);
		helper(root.right, str, list);
	}

	public static String reverseString(String str) {

		StringBuilder s = new StringBuilder(str);

		return s.reverse().toString();
	}

}
