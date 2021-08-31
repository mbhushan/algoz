/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class MaxDepthTree {
    public static void main(String[] args) {
        MaxDepthTree mdt = new MaxDepthTree();
        System.out.println(mdt.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        return 1 + Math.max(ldepth, rdepth);
    }
}
