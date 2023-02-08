import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations pp = new Permutations();
        int [] A = {1,2,3};
        List<List<Integer>> res = pp.permute(A);
        for (List<Integer> r: res) {
            System.out.println(r);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int [] A, List<List<Integer>> list, List<Integer> tmpList) {
        if (tmpList.size() == A.length) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for (int i=0; i<A.length; i++) {
                if (tmpList.contains(A[i])) continue;
                tmpList.add(A[i]);
                backtrack(A, list, tmpList);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
}
