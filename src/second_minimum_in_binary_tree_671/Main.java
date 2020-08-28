package second_minimum_in_binary_tree_671;

import java.util.PriorityQueue;

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

	public int findSecondMinimumValue(TreeNode root) {
		PriorityQueue<Integer> pq = secondMin(root, new PriorityQueue<>());
		if(pq.size() == 1) return -1;
		pq.poll();
		return pq.poll();
	}

	public PriorityQueue<Integer> secondMin(TreeNode root, PriorityQueue<Integer> pq) {
		if (root == null) return pq;
		if (pq.isEmpty()) pq.add(root.val);
		if (!pq.isEmpty()) {
			if (pq.peek() != root.val) pq.add(root.val);
		}
		secondMin(root.left, pq);
		secondMin(root.right, pq);
		return pq;
	}
}
