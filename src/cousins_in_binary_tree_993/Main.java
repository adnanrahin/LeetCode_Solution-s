package cousins_in_binary_tree_993;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<tuple> queue = new LinkedList<>();

        queue.add(new tuple(null, root, 0));

        tuple X = new tuple(null, null, 0);
        tuple Y = new tuple(null, null, 0);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                tuple current = queue.poll();

                if (current.child.val == x)
                    X = new tuple(current.parent, current.child, current.level);
                else if (current.child.val == y)
                    Y = new tuple(current.parent, current.child, current.level);

                if (current.child.left != null)
                    queue.add(new tuple(current.child, current.child.left, current.level + 1));

                if (current.child.right != null)
                    queue.add(new tuple(current.child, current.child.right, current.level + 1));
            }

            if (X.level == Y.level && X.parent != Y.parent)
                return true;

        }

        return false;
    }

    public class tuple {
        TreeNode parent;
        TreeNode child;
        int level;

        public tuple(TreeNode parent, TreeNode child, int level) {
            this.parent = parent;
            this.child = child;
            this.level = level;
        }

    }

}
