/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/565/
 */


public class CountBits {

    public static void main(String[] args) {
        CountBits cb = new CountBits();
        int n = 11111;

        System.out.println(cb.hammingWeight(n));

    }

    public int hammingWeight(int n) {
            int ones = 0;
            while(n!=0) {
                ones = ones + (n & 1);
                n = n>>>1;
            }
            return ones;
    }
}
