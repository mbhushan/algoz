import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/587/
 */

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray ms = new MergeSortedArray();
        int [] A = {2,4,6,8,0,0,0,0};
        int [] B = {1,3,5,7};
        ms.merge(A, 4, B, B.length);
        System.out.println(Arrays.toString(A));

    }

    public void merge(int[] A, int m, int[] B, int n) {
        int ptr = m+n-1;
        m = m-1;
        n = n-1;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[ptr--] = A[m--];
            } else {
                A[ptr--] = B[n--];
            }
        }
//        System.out.println("A:" + Arrays.toString(A));
//        System.out.println("ptr: " + ptr);
//        System.out.println("m: " + m + "; n: " + n);
        while (m >= 0) {
            A[ptr--] = A[m--];
        }
        while (n >= 0) {
            System.out.println("ptr: " + ptr + "; n: " + n);
            A[ptr--] = B[n--];
        }
    }
}
