package even_odd_tree_1609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


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

    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            return isEvenOddTree(root, new HashMap<>(), 0);
        }

        public boolean isEvenOddTree(TreeNode root, Map<Integer, List<Integer>> map, int level) {
            if (root == null) return true;
            if (!map.containsKey(level)) map.put(level, new ArrayList<>());

            List<Integer> list = map.get(level);

            if (level % 2 == 0) {
                if (root.val % 2 == 1) return false;
                if (list.size() > 0 && list.get(list.size() - 1) >= root.val) {
                    return false;
                } else list.add(root.val);
            } else {
                if (root.val % 2 == 0) return false;
                if (list.size() > 0 && list.get(list.size() - 1) <= root.val) {
                    return false;
                } else list.add(root.val);
            }

            if (!isEvenOddTree(root.left, map, level + 1)) return false;
            return isEvenOddTree(root.right, map, level + 1);
        }

    }

}
