import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int [] A= {1,2,3,4,5,6,7};
        int k = 3;
        ra.rotate(A, k);
        System.out.println("output array: " + Arrays.toString(A));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int []A, int low, int high) {
        while (low < high) {
            int tmp = A[low];
            A[low] = A[high];
            A[high] = tmp;
            ++low;
            --high;
        }
    }
}
