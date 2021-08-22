import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int [][] A = {
                {1,2,3,1},
                {1,2,3,4},
                {1,1,1,3,3,4,3,2,4,2}
        };

        for (int i=0; i<A.length; i++) {
            System.out.println(Arrays.toString(A[i]) + ": " + cd.containsDuplicate(A[i]));
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
