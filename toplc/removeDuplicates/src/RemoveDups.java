import java.util.Arrays;

public class RemoveDups {
    public static void main(String [] args) {
        RemoveDups rd = new RemoveDups();
        int [] A = {1,1,2,2,3,3,4,4};
        int [] B = {0,0,1,1,1,2,2,3,3,4};
        int ans = rd.removeDuplicates(A);
        System.out.println("result: " + ans);
    }

    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 1) {
            return A.length;
        }
        int ptr = 0;
        int i=1;
        while (i < A.length) {
            if (A[i] != A[ptr]) {
                A[++ptr] = A[i];
            }
            ++i;
        }
        System.out.println(Arrays.toString(A));
        return ptr+1;
    }


}
