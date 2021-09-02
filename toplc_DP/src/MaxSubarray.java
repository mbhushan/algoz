/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/566/
 */

public class MaxSubarray {

    public static void main(String[] args) {
        MaxSubarray mx= new MaxSubarray();
        int [] A = {-2,1,-3,4,-1,2,1,-5,4};
        int res = mx.maxSubArray(A);
        System.out.println("res: " + res);
    }

    public int maxSubArray(int[] A) {
        if (A == null || A.length < 1) {
            return Integer.MIN_VALUE;
        }
        int maxFar = A[0];
        int res = maxFar;
        for (int i=1; i<A.length; i++) {
            maxFar = Math.max(maxFar+A[i], A[i]);
            res = Math.max(res, maxFar);
        }
        return res;
    }


}
