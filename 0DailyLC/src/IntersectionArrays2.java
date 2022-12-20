import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArrays2 {

    public static void main(String[] args) {
        IntersectionArrays2 ia = new IntersectionArrays2();

        int [] A = {4,9,5};
        int [] B = {9,4,9,8,4};
        int [] R = ia.intersect(A, B);
        System.out.println(Arrays.toString(R));

    }

    public int[] intersect(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int i=0, j=0;
        List<Integer> list = new ArrayList<>();
        while ((i < A.length) && (j < B.length)) {
            if (A[i] < B[j]) {
                ++i;
            } else if (A[i] > B[j]) {
                ++j;
            } else {
                list.add(A[i]);
                ++i;
                ++j;
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}
