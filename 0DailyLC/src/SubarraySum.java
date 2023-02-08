import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int [] A = {1,2,3};

        System.out.println(ss.subarraySum(A, 3));

    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
               result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }

        return result;
    }
}
