package construct_string_from_binary_tree_606;

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

    public static class Solution {

        public String tree2str(TreeNode t) {
            StringBuilder stringBuilder = new StringBuilder();
            backTrack(t, stringBuilder);
            return stringBuilder.toString();
        }

        public void backTrack(TreeNode root, StringBuilder str) {
            if (root == null) return;

            str.append(root.val);

            if (root.left != null) {
                str.append("(");
                backTrack(root.left, str);
                str.append(")");
            } else if (root.left == null && root.right != null) {
                str.append("()");
            }
            if (root.right != null) {
                str.append("(");
                backTrack(root.right, str);
                str.append(")");
            }
        }

    }

}
