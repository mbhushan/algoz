import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int [] A = {1,2,3,4,5,6,7};
        int k = 3;
        ra.rotate(A, k);
        System.out.println(Arrays.toString(A));
    }

    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length <= 1) {
            return;
        }
        k = k%nums.length;
        rotateHelper(nums, 0, nums.length-1);
        rotateHelper(nums, 0, k-1);
        rotateHelper(nums, k, nums.length-1);
    }

    private void rotateHelper(int []nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}
