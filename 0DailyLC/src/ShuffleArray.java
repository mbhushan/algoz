import java.util.Random;

public class ShuffleArray {
    private int[] nums;
    private Random random;

    public static void main(String[] args) {

    }

    public void Demo(int [] A) {
        this.nums = A;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) return nums;
        int [] A = nums.clone();
        for (int j=1; j<A.length; j++) {
            int i = random.nextInt(j+1);
            swap(A, i, j);
        }

        return A;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
