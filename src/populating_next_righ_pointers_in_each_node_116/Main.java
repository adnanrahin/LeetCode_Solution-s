package populating_next_righ_pointers_in_each_node_116;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null) return root;

        Map<Integer, List<Node>> map = new HashMap<>();
        levelOrderTraversal(0, map, root);

        map.get(0).get(0).next = null;
        map.get(0).get(0).left = map.get(1).get(0);
        map.get(0).get(0).right = map.get(1).get(1);

        for (Integer level : map.keySet()) {
            if (level == 0) continue;
            List<Node> list = map.get(level);
            for (int i = 0; i < list.size() - 1; i++) {
                if (!map.containsKey(level + 1)) {
                    list.get(i).next = list.get(i + 1);
                } else {
                    list.get(i).next = list.get(i + 1);
                    list.get(i).left = map.get(level + 1).get(2 * i);
                    list.get(i).right = map.get(level + 1).get((2 * i) + 1);
                }
            }
        }
        return map.get(0).get(0);
    }

    public void levelOrderTraversal(int level, Map<Integer, List<Node>> map, Node root) {
        if (root == null) return;
        if (!map.containsKey(level)) map.put(level, new ArrayList<>());
        map.get(level).add(new Node(root.val, null, null, null));
        levelOrderTraversal(level + 1, map, root.left);
        levelOrderTraversal(level + 1, map, root.right);
    }

}