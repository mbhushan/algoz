/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/745/
 */

public class PowerOfThree {

    public static void main(String[] args) {
        PowerOfThree pt = new PowerOfThree();

        for (int i=0; i<100; i++) {
            if (pt.isPowerOfThree(i)) System.out.println("i: " + i);
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        while (n%3 == 0) {
            n = n/3;
        }

        return n == 1;
    }
}
