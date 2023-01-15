import java.util.*;

public class ThreeSome {
    public static void main(String[] args) {
        ThreeSome ts = new ThreeSome();
        int [] A = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = ts.threeSum(A);
        for (List<Integer> l: list) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res  = new HashSet<>();

        for (int left=0; left<nums.length-2; left++) {
            int mid = left+1;
            int right = nums.length-1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(new Integer[] {nums[left], nums[mid], nums[right]}));
                    ++mid;
                    --right;
                } else if (sum < 0) {
                    ++mid;
                } else {
                    --right;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
