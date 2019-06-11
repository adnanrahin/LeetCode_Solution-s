package n_ary_tree_preorder_traversal_589;

import java.util.ArrayList;
import java.util.List;

public class Main {

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

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorder(Node root) {

		if (root == null)
			return list;

		list.add(root.val);

		for (Node subtreeNode : root.children) {
			preorder(subtreeNode);
		}

		return list;
	}
}
