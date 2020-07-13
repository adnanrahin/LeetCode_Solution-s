package construct_binary_tree_from_preorder_and_inorder_traversal_105;

import java.util.HashMap;
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

    int counter = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return depthFirstSearch(0, preorder.length - 1, preorder, inorderMap);
    }

    public TreeNode depthFirstSearch(int start, int end, int[] preorder, Map<Integer, Integer> map) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[counter++]);

        root.left = depthFirstSearch(start, map.get(root.val) - 1, preorder, map);
        root.right = depthFirstSearch(map.get(root.val) + 1, end, preorder, map);

        return root;
    }

}
