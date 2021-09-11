/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/722/
 */

public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int [] A = {9,6,4,2,3,5,7,0,1};

        System.out.println("missing number: " + mn.missingNumber(A));

    }

    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i=0; i<nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }


}
