import java.util.*;

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
        btops.printlevelorder(root);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        Q.add(root);
        cols.add(0);
        int min = 0;
        int max = 0;

        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                Q.add(node.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }
            if (node.right != null) {
                Q.add(node.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }
        for (int i=min; i<=max; i++) {
           result.add(map.get(i)) ;
        }
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int []A, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, left, mid-1);
        node.right = helper(A, mid+1, right);
        return node;
    }

    public void printlevelorder(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> r: res) {
            for (int i: r)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            List<Integer> acc = new ArrayList<>();
            int qsize = Q.size();
            for (int i=0; i<qsize; i++) {
                if (Q.peek().left != null) Q.offer(Q.peek().left);
                if (Q.peek().right != null) Q.offer(Q.peek().right);
                acc.add(Q.poll().val);
            }
            result.add(acc);
        }
        return result;
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
