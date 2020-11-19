package n_ary_tree_level_order_traversal_429;

import java.util.*;

public class Main {

    public static void main(String args[]) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public class StackBasedSolution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> levelOrder = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> local = new ArrayList<>();
                for (int i = 0; i <= size; i++) {
                    TreeNode parent = queue.peek();
                    queue.remove();
                    local.add(parent.val);
                    if (parent.left != null) queue.add(parent.left);
                    if (parent.right != null) queue.add(parent.right);
                }
                levelOrder.add(new ArrayList<>(local));
            }
            return levelOrder;
        }
    }

    public class HashTableBasedSolution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levelOrder = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            levelOrder(root, map, 0);

            for (Integer key : map.keySet()) {
                levelOrder.add(map.get(key));
            }
            return levelOrder;
        }

        public void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int level) {
            if (root == null) return;
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(root.val);
            levelOrder(root.left, map, level + 1);
            levelOrder(root.right, map, level + 1);
        }
    }

}
