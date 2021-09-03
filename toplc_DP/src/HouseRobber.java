import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/576/
 */

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int [] A = {2,1,1,2};
        System.out.println("res: " + hr.rob(A));
        System.out.println("res: " + hr.robRec(A));
        System.out.println("res: " + hr.robRecMemo(A));
    }

    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int i=0; i<nums.length; i++) {
            int tmp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = tmp;
            System.out.println("prev: " + prev + "; curr: " + curr);
        }
        return curr;
    }

    public int robRec(int [] A) {
        return robRecHelper(A, A.length-1);
    }
    private int robRecHelper(int [] A, int n) {
        if (n < 0) {
            return 0;
        }
        return Math.max((robRecHelper(A, n-2)+A[n]), robRecHelper(A, n-1));
    }

    public int robRecMemo(int [] A) {
        int [] memo = new int[A.length+1];
        Arrays.fill(memo, -1);

        return robRecMemoHelper(A, A.length-1, memo);
    }

    private int robRecMemoHelper(int[] A, int n, int []memo) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] > -1) {
            return memo[n];
        }
        return Math.max((robRecMemoHelper(A, n-2, memo)+A[n]), robRecMemoHelper(A, n-1, memo));
    }
}
