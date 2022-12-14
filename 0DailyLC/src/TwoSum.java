import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        //int A[] = {2,7,11,15};
        int A[] = {3,2,3};
        int target = 6;
        TwoSum ts = new TwoSum();
        int R[] = ts.twoSum(A, target);
        int S[] = ts.twoSumv2(A, target);
        System.out.println("Result: " + Arrays.toString(R));
        System.out.println("Result: " + Arrays.toString(S));
    }

    public int[] twoSumv2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            List<Integer> indices = map.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            map.put(nums[i], indices);
        }

        for (int n: nums) {
            int diff = target - n;
            // case 1: n and diff are different numbers
            if ((diff != n) && map.containsKey(diff)) {
               return new int[] {map.get(n).get(0), map.get(diff).get(0)};
            } else if ((diff == n) && map.containsKey(diff) && (map.get(n).size() >= 2)) {
                return new int[] {map.get(n).get(0), map.get(diff).get(1)};
            }
        }
        return new int[]{-1, -1};
    }
}
