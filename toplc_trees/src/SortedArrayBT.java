/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/631/
 */

public class SortedArrayBT {

    public static void main(String[] args) {
        SortedArrayBT sa = new SortedArrayBT();
        int [] A = {1,2,3,4,5};
        sa.sortedArrayToBST(A);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        int low = 0;
        int high = nums.length-1;

        return helper(nums, low, high);
    }

    private TreeNode helper(int [] A, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, low, mid-1);
        node.right = helper(A, mid+1, high);
        return node;
    }
}
