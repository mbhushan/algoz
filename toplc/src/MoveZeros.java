import java.lang.reflect.Array;
import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/
 */


public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int [] A = {0,1,0,3,12};

        mz.moveZeroes(A);
        System.out.println(Arrays.toString(A));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                ++i;
            }
            ++j;
        }
    }
}
