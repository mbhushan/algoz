import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 */

public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
        System.out.println(bst.isValidBST(null));
    }

    private List<Integer> inorder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {return list;}

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
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
