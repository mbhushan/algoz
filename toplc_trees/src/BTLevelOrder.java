import java.util.*;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/628/
 */

public class BTLevelOrder {

    public static void main(String[] args) {
        BTLevelOrder bt = new BTLevelOrder();
        bt.levelOrder(null);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode marker = new TreeNode(-1);
        queue.add(root);
        List<Integer> level = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == marker) {
                if (!queue.isEmpty()) {
                    queue.add(marker);
                }
                System.out.println(level);
                res.add(List.copyOf(level));
                level = new LinkedList<>();
            } else{
                level.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return res;
    }
}
