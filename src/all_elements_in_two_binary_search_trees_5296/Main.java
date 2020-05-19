package all_elements_in_two_binary_search_trees_5296;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Integer> l1 = Arrays.asList(1, 2, 3, 5, 6);
        List<Integer> l2 = Arrays.asList(9, 10, 20);

        System.out.println(mergeList(l1, l2));

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> tree1 = inorder_traversal(root1, new ArrayList<>());
        List<Integer> tree2 = inorder_traversal(root2, new ArrayList<>());

        return mergeList(tree1, tree2);

    }

    public static List<Integer> inorder_traversal(TreeNode root, List<Integer> solution) {
        if (root == null)
            return solution;

        inorder_traversal(root.left, solution);
        solution.add(root.val);
        inorder_traversal(root.right, solution);

        return solution;
    }

    public static List<Integer> mergeList(List<Integer> l1, List<Integer> l2) {
        List<Integer> solution = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {

            if (l1.get(i) > l2.get(j)) {
                solution.add(l2.get(j));
                j++;
            } else if (l1.get(i) < l2.get(j)) {
                solution.add((l1.get(i)));
                i++;
            } else {
                solution.add(l1.get(i++));
                solution.add(l2.get(j++));
            }
        }

        if (i == l1.size()) {
            while (j < l2.size())
                solution.add(l2.get(j++));
        }

        if (j == l2.size()) {
            while (i < l1.size())
                solution.add(l1.get(i++));
        }

        return solution;

    }

}
