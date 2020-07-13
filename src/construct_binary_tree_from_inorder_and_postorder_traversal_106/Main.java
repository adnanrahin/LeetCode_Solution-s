package construct_binary_tree_from_inorder_and_postorder_traversal_106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        counter = postorder.length - 1;


        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return buildTree(0, postorder.length - 1, postorder, inorderMap);
    }

    public TreeNode buildTree(int start, int end, int[] postorder, Map<Integer, Integer> inOrderMap) {
        if (start > end) return null;

        TreeNode root = new TreeNode(postorder[counter--]);

        root.right = buildTree(inOrderMap.get(root.val) + 1, end, postorder, inOrderMap);
        root.left = buildTree(start, inOrderMap.get(root.val) - 1, postorder, inOrderMap);

        return root;
    }

}
