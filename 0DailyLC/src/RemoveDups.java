import java.util.Arrays;

public class RemoveDups {
    public static void main(String [] args) {
        RemoveDups rd = new RemoveDups();
        int [] A = {1, 1, 2};
        System.out.println("input array: " + Arrays.toString(A));
        int k = rd.removeDuplicates(A);
        System.out.println("unique elements: " + k);
        System.out.println("output array: " + Arrays.toString(A));

    }

    public int removeDuplicates(int[] A) {
        if (A == null) {
            return -1;
        }
        int back = 0;
        int front = 0;
        while (front < A.length) {
            if (A[back] != A[front]) {
                //copy A[front] to A[back+1]
                A[++back] = A[front];
            }
            ++front;
        }
        return back+1; // need to consider 0 based index.
    }
}
