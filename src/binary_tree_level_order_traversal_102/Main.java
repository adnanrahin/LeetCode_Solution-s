package binary_tree_level_order_traversal_102;

import java.util.*;

public class Main {

    public static void main(String args[]) {

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class DepthFirstSearch {

    Map<Integer, List<Integer>> map;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }

        map = new HashMap<>();
        map.put(0, new ArrayList<>());
        treeTraversal(root, 0);

        for (Map.Entry<Integer, List<Integer>> itr : map.entrySet()) {
            solution.add(itr.getValue());
        }

        return solution;
    }

    public void treeTraversal(TreeNode root, int level) {

        if (root == null)
            return;

        treeTraversal(root.left, level + 1);
        if (map.containsKey(level))
            map.get(level).add(root.val);
        else {
            map.put(level, new ArrayList<>());
            map.get(level).add(root.val);
        }
        treeTraversal(root.right, level + 1);

        return;
    }

}

class BreathFirstSearch {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        List<Integer> list = new LinkedList<>();

        if (root == null)
            return ans;

        q.add(root);

        while (!q.isEmpty()) {

            list = new LinkedList<Integer>();

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode u = q.peek();
                q.remove();
                list.add(u.val);
                if (u.left != null) {
                    q.add(u.left);
                }
                if (u.right != null) {
                    q.add(u.right);
                }
            }

            ans.add(list);
        }
        return ans;
    }
}