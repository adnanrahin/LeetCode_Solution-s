package sum_root_to_leaf_numbers_129;

public class Main {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {

	}

	public static int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;

		return preordersum(root, 0);
	}

	public static int preordersum(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}

        sum = (sum * 10) + root.val;
        
		if (root.left == null && root.right == null) 
			return sum;
		
		return preordersum(root.right, sum) + preordersum(root.left, sum);

	}

}
