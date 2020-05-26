package conver_sorted_array_to_binary_search_tree_108;

public class TreeNode {

	int val, height;
	TreeNode right, left;

	public TreeNode(int val) {
		this.val = val;
		height = 1;
	}

}

class Solution {

	TreeNode root;

	public TreeNode sortedArrayToBST(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			insert(nums[i]);
		}
		return root;
	}

	public void pretorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		pretorder(root.left);
		pretorder(root.right);
	}

	public int Height(TreeNode root) {

		if (root == null)
			return 0;

		return root.height;

	}

	public void insert(int newData) {
		root = insert(root, newData);
	}

	public TreeNode rightrotate(TreeNode y) {
		TreeNode x = y.left;
		TreeNode t2 = x.right;

		x.right = y;
		y.left = t2;

		y.height = Math.max(Height(y.left), Height(y.right)) + 1;
		x.height = Math.max(Height(x.left), Height(x.right)) + 1;

		return x;
	}

	public TreeNode leftrotate(TreeNode x) {
		TreeNode y = x.right;
		TreeNode t2 = y.left;

		y.left = x;
		x.right = t2;

		x.height = Math.max(Height(x.left), Height(x.right)) + 1;
		y.height = Math.max(Height(y.left), Height(y.right)) + 1;

		return y;
	}

	public int getbalance(TreeNode root) {
		if (root == null)
			return 0;
		return Height(root.left) - Height(root.right);
	}

	public TreeNode insert(TreeNode root, int val) {

		if (root == null)
			return (new TreeNode(val));
		if (val < root.val)
			root.left = insert(root.left, val);
		else if (val > root.val)
			root.right = insert(root.right, val);

		else
			return root;

		root.height = 1 + Math.max(Height(root.left), Height(root.right));

		int balance = getbalance(root);

		if (balance > 1 && val < root.left.val)
			return rightrotate(root);

		if (balance < -1 && val > root.right.val)
			return leftrotate(root);

		if (balance > 1 && val > root.left.val) {
			root.left = leftrotate(root.left);
			return rightrotate(root);
		}
		if (balance < -1 && val < root.right.val) {
			root.right = rightrotate(root.right);
			return leftrotate(root);
		}

		return root;

	}

}
