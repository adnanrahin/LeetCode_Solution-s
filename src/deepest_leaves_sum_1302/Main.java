package deepest_leaves_sum_1302;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        Hashtable<Integer, Integer> t = new Hashtable<>();
        t.put(1, 2);
        t.put(2, 2);
        t.put(3, 2);

        for (Map.Entry<Integer, Integer> itr : t.entrySet())
            System.out.println(itr.getKey());

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    static Map<Integer, List<Integer>> table;

    public static int deepestLeavesSum(TreeNode root) {

        table = new HashMap<>();
        table.put(0, new ArrayList<>());
        table.get(0).add(root.val);
        treeTraversal(root, 0);

        int max = 0;

        for (Map.Entry<Integer, List<Integer>> itr : table.entrySet()) {
            int key = itr.getKey();
            if (max < key)
                max = key;
        }

        int sum = 0;

        for (int i = 0; i < table.get(max).size(); i++) {
            sum += table.get(max).get(i);
        }

        return sum;

    }

    public static void treeTraversal(TreeNode root, int level) {

        if (root == null)
            return;

        treeTraversal(root.left, level + 1);
        if (table.containsKey(level))
            table.get(level).add(root.val);
        else {
            table.put(level, new ArrayList<>());
            table.get(level).add(root.val);
        }
        treeTraversal(root.right, level + 1);

        return;
    }
}
