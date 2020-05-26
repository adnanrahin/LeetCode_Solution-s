package same_tree_100;

public class Main {

	public static void main(String args[]) {

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p != null && q == null)
			return false;

		if (p == null && q != null)
			return false;

		if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
			return true;

		return false;

	}

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {

			val = x;

		}

	}

}
