import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/explore/interview/card/facebook/53/recursion-3/292/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class PermutationsUnique {
    public static void main(String[] args) {
        PermutationsUnique pu = new PermutationsUnique();
        int [] A = {1,2,1};
        List<List<Integer>> res = pu.permute(A);
        for (List<Integer> r: res) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<>(), used);
        return list;
    }

    private void backtrack(int [] A, List<List<Integer>> list, List<Integer> tmpList, boolean []used) {
        if (tmpList.size() == A.length) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for (int i=0; i<A.length; i++) {
                if (used[i] || (i > 0 && A[i] == A[i-1] && !used[i-1])) continue;
                used[i] = true;
                tmpList.add(A[i]);
                backtrack(A, list, tmpList, used);
                used[i] = false;
                tmpList.remove(tmpList.size()-1);
            }
        }
    }

}
