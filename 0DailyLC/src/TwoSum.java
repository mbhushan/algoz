import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        //int A[] = {2,7,11,15};
        int A[] = {3,2,3};
        int target = 6;
        TwoSum ts = new TwoSum();
        int R[] = ts.twoSum(A, target);
        System.out.println("Result: " + Arrays.toString(R));
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
