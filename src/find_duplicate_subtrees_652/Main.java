package find_duplicate_subtrees_652;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		if (root == null)
			return new ArrayList<TreeNode>();

		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<TreeNode> answer = new ArrayList<TreeNode>();
		Set<String> set = new HashSet<String>();

		treeNodes = treeTravers(root, treeNodes);

		Set<String> treeStrings = new HashSet<String>();

		for (int i = 0; i < treeNodes.size(); i++) {
			String str = treeTravers(treeNodes.get(i), "");
			if (treeStrings.contains(str) && !set.contains(str)) {
				answer.add(treeNodes.get(i));
				set.add(str);
			} else
				treeStrings.add(str);
		}

		return answer;

	}

	public static String treeTravers(TreeNode root, String str) {
		if (root == null)
			return str;
		str += Integer.toString(root.val);
		treeTravers(root.left, str);
		treeTravers(root.right, str);

		return str;
	}

	public static List<TreeNode> treeTravers(TreeNode root, List<TreeNode> tree) {

		if (root == null)
			return tree;
		tree.add(root);
		treeTravers(root.left, tree);
		treeTravers(root.right, tree);

		return tree;

	}

}
