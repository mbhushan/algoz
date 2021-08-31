/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 */

public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
        System.out.println(bst.isValidBST(null));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer max, Integer min) {
        if (node == null) {
            return true;
        }

        if ((max != null && node.val >= max) || (min != null && node.val <= min)) {
            return false;
        }

        return helper(node.left, node.val, min) &&
                helper(node.right, max, node.val);
    }
}
