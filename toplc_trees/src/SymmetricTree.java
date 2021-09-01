/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/627/
 */

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();

        st.isSymmetric(null);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}
