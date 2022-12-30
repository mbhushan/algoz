import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int [] A = new int[10];
        int n = 1;
        for (int i=0; i<(A.length/2); i++) {
            A[i] = n;
            n += 2;
        }
        int [] B = {2,4,6,8,10};
        msa.merge(A, 5, B, 5);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = 0, k=0;

        while (j < m && k < n) {
            if (nums1[j] <= nums2[k]) {
                nums1[i--] = nums1[j++];
            } else {
                nums1[i--] = nums2[k++];
            }
        }
        while (j < m) {
            nums1[i--] = nums1[j++];
        }
        while (k < n) {
            nums1[i--] = nums2[k++];
        }
    }
}
