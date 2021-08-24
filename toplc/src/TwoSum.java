import java.util.*;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/546/
 */

public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int [] A = {2,7,11,15};

        int [] R = ts.twoSum(A, 9);
        System.out.println(Arrays.toString(R));

        int [] B = {3,2,4};
        int target = 6;
        R = ts.twoSum(B, target);
        System.out.println(Arrays.toString(R));


    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        for (int i=0; i<nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            //equal num
            if (x == y && map.get(x).size() >= 2) {
                List<Integer> list = map.get(x);
                return new int[] {list.get(0), list.get(1)};
            }
            if (x != y && map.containsKey(y)) {
                return new int[] {i, map.get(y).get(0)};
            }
        }
        return null;
    }
}
