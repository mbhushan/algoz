import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();

        int [] A = {1,1,1,3,3,4,3,2,4,2};
        System.out.println("contains duplicate: " + cd.containsDuplicate(A));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> hset = new HashSet<>();
        for (int n: nums) {
            if (hset.contains(n)) {
                return true;
            }
            hset.add(n);
        }
        return false;
    }
}
