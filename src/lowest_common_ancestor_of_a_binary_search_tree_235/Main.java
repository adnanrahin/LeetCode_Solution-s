package lowest_common_ancestor_of_a_binary_search_tree_235;

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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root.val >= p.val && root.val < q.val)
			return root;

		else if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);

		else if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);

		else
			return root;

	}

}
