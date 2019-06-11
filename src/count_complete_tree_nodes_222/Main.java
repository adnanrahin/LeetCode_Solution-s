package count_complete_tree_nodes_222;

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

	public static int countNodes(TreeNode root) {
		
		if(root == null) return 0;
		count = 0;
		helper(root);
				
		return count;
	}
	
	static int count = 0;
	
	public static void helper(TreeNode root) {
		
		if(root == null) return;
		
		helper(root.left);
		count++;
		helper(root.right);
		
	}

}
