package increasing_order_search_tree_897;

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

    public TreeNode increasingBST(TreeNode root) {


        List<Integer> list = new ArrayList<>();

        list = helper(root, list);

        TreeNode solution = new TreeNode(0);

        TreeNode temp = solution;

        for (Integer val : list) {
            temp.right = new TreeNode(val);
            temp = temp.right;
        }

        return solution.right;
    }

    public List<Integer> helper(TreeNode root, List<Integer> list) {

        if (root == null)
            return list;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
        return list;

    }

}
