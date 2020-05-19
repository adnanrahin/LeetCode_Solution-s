package maximum_depth_of_binary_tree_104;

public class Main {

	public static void main(String args[]) {

	}

}

class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
	     
        if(root == null) return 0;
        
        int lefth = maxDepth(root.left);
        int righth = maxDepth(root.right);

        return Math.max(lefth, righth) + 1;
    
    }
}
