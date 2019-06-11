package kth_smallest_element_in_a_BST_230;

import java.util.ArrayList;
import java.util.List;

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

	public static List<Integer> list;
	
	public int kthSmallest(TreeNode root, int k) {

		list = new ArrayList<Integer>();
		
		helper(root);
		
		return list.get(k - 1);
	}

	
	
	public static void helper(TreeNode root) {
		
		if(root == null) return;
		
		helper(root.left);
		list.add(root.val);
		helper(root.right);
		
		return;
		
	}

}
