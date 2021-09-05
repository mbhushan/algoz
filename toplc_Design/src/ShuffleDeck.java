import java.util.Arrays;
import java.util.Random;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/670/
 */

public class ShuffleDeck {



    public static void main(String[] args) {
        int [] A = {1,2,3,4,5,6,7,8,9};

        ShuffleDeck sd = new ShuffleDeck(A);
        A = sd.shuffle();
        System.out.println("A: " + Arrays.toString(A));

    }

    private Random random;
    private int [] nums;
    public ShuffleDeck(int [] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int [] A = nums.clone();
        for (int i=1; i<A.length; i++) {
            int j = random.nextInt(i+1);
            swap (A, i, j);
        }
        return A;
    }

    private void swap(int [] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
