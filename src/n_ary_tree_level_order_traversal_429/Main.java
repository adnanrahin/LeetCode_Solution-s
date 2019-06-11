package n_ary_tree_level_order_traversal_429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String args[]) {

	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {

		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	List<List<Integer>> answer = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(Node root) {

		if (root == null)
			return answer;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {

			List<Integer> list = new ArrayList<Integer>();

			int size = queue.size();

			for (int i = 0; i < size; i++) {

				Node node = queue.peek();
				queue.remove();
				list.add(node.val);

				for (Node treechildNode : node.children)
					queue.add(treechildNode);

			}

			answer.add(list);

		}

		return answer;
	}

}
