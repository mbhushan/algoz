import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2 s2 = new Subsets2();
        int [] A = {1,2,2};
        List<List<Integer>> res = s2.subsets(A);
        for (List<Integer> r: res) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmpList = new ArrayList<>();
        int index = 0;
        backtrack(result, tmpList, nums, index);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int [] A, int index) {
        result.add(new ArrayList<>(tmpList));
        for (int i=index; i<A.length; i++) {
            if (i>index && A[i] == A[i-1]) continue;
            tmpList.add(A[i]);
            backtrack(result, tmpList, A, i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
