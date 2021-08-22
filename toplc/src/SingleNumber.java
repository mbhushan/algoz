import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        int [][]A = {
                {4,1,2,1,2},
                {2,2,1}
        };

        for (int i=0; i<A.length; i++) {
            System.out.println(Arrays.toString(A[i]) + ": " + sn.singleNumber(A[i]));
        }

    }

    public int singleNumber(int[] nums) {
        int res = 0 ;
        for (int n: nums) {
            res = res ^ n;
        }
        return res;
    }
}
