package minimum_absolute_difference_in_BST_530;

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

	int def = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        
        if(root == null) return def;
    
        getMinimumDifference(root.left);

        if(prev != null){
            def = Math.min(def, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        
        return def;
    }
}