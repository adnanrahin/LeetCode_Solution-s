package cousins_in_binary_tree_993;

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

	public static boolean isCousins(TreeNode root, int x, int y) {

		if (root == null)
			return false;

		int xlevel = getLevelOfNode(root, x, 0);
		int ylevel = getLevelOfNode(root, y, 0);

		System.out.println(xlevel + " " + ylevel);

		return xlevel == ylevel;

	}

	public static int findParents(TreeNode root, int key, int parent) {
		
		if(root == null)
			return -1;
		
		return 0;
	}
	
	public static int getLevelOfNode(TreeNode root, int key, int level) {
		if (root == null)
			return 0;
		if (root.val == key)
			return level;

		int result = getLevelOfNode(root.left, key, level + 1);
		if (result != 0) {

			return result;
		}
		result = getLevelOfNode(root.right, key, level + 1);

		return result;
	}

}
