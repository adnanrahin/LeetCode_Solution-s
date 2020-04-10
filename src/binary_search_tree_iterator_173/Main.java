package binary_search_tree_iterator_173;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(null);
        iterator.next();    // return 3
        iterator.next();    // return 7
        iterator.hasNext(); // return true
        iterator.next();    // return 9
        iterator.hasNext(); // return true
        iterator.next();    // return 15
        iterator.hasNext(); // return true
        iterator.next();    // return 20
        iterator.hasNext(); // return false
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

class BSTIterator {

    TreeNode root;

    List<Integer> inorder;

    int index;

    public BSTIterator(TreeNode root) {
        this.root = root;
        index = 0;
        inorder = new ArrayList<>();
        inOrder(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return inorder.get(index++);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        inorder.add(root.val);
        inOrder(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return (inorder.size() > index);
    }
}
