import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        MissingRanges mr = new MissingRanges();
        int [] A = {0,1,3,50,75};
        int lower = 0, upper = 99;
        List<List<Integer>> res = new ArrayList<>();
        res = mr.findMissingRanges(A, lower, upper);
        System.out.println(res);
    }

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        // 1. sanity checks
        // 2a. left, middle, right.
        // 2a. if nums[0] is greater than lower
        // 2. go through A in pairs l, h. Check if numbers bw/ l and h are between lower and upper
        // 3. if yes then log the result
        // 4. return the accum result.

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(upper);
            return res;
        }

        if (nums[0] > lower) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(nums[0]-1);
            res.add(list);
        }
        for (int i=0; i<nums.length-1; i++) {
            int l = nums[i]+1;
            int h = nums[i+1]-1;
            if (l > h) continue;
            List<Integer> list = new ArrayList<>();
            if (l == h && (l >= lower && h <= upper)) {
                list.add(l);
                list.add(h);
                res.add(list);
            } else {
                if (l >= lower && l <= upper) {
                    list.add(l);
                }
                while (h >= upper) h--;
                if (h >= l) list.add(h);
                res.add(list);
            }
        }
        if (nums[nums.length-1] < upper) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[nums.length-1]+1);
            list.add(upper);
            res.add(list);
        }

        return res;
    }
}
