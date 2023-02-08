import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String [] args) {
        Subsets ss = new Subsets();
        int [] A = {1,2,3};
        List<List<Integer>> res = ss.subsets(A);
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
            tmpList.add(A[i]);
            backtrack(result, tmpList, A, i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
