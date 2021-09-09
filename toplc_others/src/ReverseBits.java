/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/648/
 */

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        int n = 964176192;
        System.out.println("rev bits: " + rb.reverseBits(n));
    }

    public int reverseBits(int n) {
        int z = 0;
        int b = 32;
        while(b-- > 0) {
            z = z << 1;
            if ((n&1) == 1) z += 1;
            n = n >> 1;
        }
        return z;
    }
}
