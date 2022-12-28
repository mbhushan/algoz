
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
