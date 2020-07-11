package unique_binary_search_trees_II_95;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

    }


    public static class TreeNode {
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

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generate(1, n);
    }

    public static List<TreeNode> generate(int start, int end) {

        List<TreeNode> solution = new ArrayList<>();

        if (start > end) {
            solution.add(null);
            return solution;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generate(start, i - 1);
            List<TreeNode> rightTree = generate(i + 1, end);
            for (TreeNode node : leftTree) {
                for (TreeNode treeNode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = node;
                    root.right = treeNode;
                    solution.add(root);
                }
            }

        }

        return solution;

    }


}
