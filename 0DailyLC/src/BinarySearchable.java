import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySearchable {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        BinarySearchable bs = new BinarySearchable();

        int [] A = {3, 1, 7, 6, 4, 5, 2};

        bs.searchableCount(A);

    }



    public void searchableCount(int [] A) {

        helper(A, 0, A.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int count = 0;
        System.out.println("map: " + map);
        for (Map.Entry e: map.entrySet()) {
            // System.out.println(A[(Integer)e.getKey()] + ": " + e.getValue());
            List<Integer> pair = (List<Integer>) e.getValue();
            int idx = (int) e.getKey();
            int x = (Integer)pair.get(0);
            int y = (Integer) pair.get(1);
            if (A[idx] > x && A[idx] < y) {
                ++count;
                System.out.println("binary searchable: " + A[idx]);
            }

        }

        System.out.println("total binary searchable elements: " + count);

    }

    private void helper(int [] A, int low, int high, int min, int max) {

        if (low > high) {
            return;
        }

        int mid = low + (high - low)/2;
        List<Integer> list = new ArrayList<>();
        list.add(min); list.add(max);
        map.put(mid, list);

        helper(A, low, mid-1, min, A[mid]);
        helper(A, mid+1, high, A[mid], max);
    }
}
