
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeOps {
    public static void main(String[] args) {
        BinaryTreeOps btops = new BinaryTreeOps();
        int [] A = {8, 3, 10, 1, 6, 18, 4, 7, 13, 15};
        TreeNode root = null;
        root = btops.buildBT(A, root);
        btops.printTree(root);
        System.out.println();
        System.out.println("max depth: " + btops.maxDepth(root));
        System.out.println("valid bst: " + btops.isValidBST(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        return (A.val == B.val) && helper(A.left, B.right) && helper(A.right, B.left);
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }

    public boolean isValidBSTv1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null ) && (root.left.val > root.val)) {
            return false;
        }
        if ((root.right != null) && (root.right.val <= root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }

    void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
        }
    }


    TreeNode buildBT(int [] A, TreeNode root) {
        if (A == null || A.length < 1) {
            return root;
        }
        for (int n: A) {
            root = insertIntoBT(root, n);
        }
        return root;
    }

    TreeNode insertIntoBT(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val <= node.val) {
            node.left = insertIntoBT(node.left, val);
        } else {
            node.right = insertIntoBT(node.right, val);
        }
        return node;
    }


}
