package n_ary_Tree_postorder_traversal_590;

import java.util.ArrayList;
import java.util.List;

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

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorder(Node root) {

		if (root == null)
			return list;

		for (Node childnode : root.children) {

			postorder(childnode);

		}

		list.add(root.val);

		return list;

	}

}
