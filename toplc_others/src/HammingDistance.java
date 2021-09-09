/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/762/
 */

public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        int x = 1, y = 4;
        System.out.println(hd.hammingDistance(x, y));

    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return numBits(z);
    }

    private int numBits(int z) {
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) ++count;
            z = z >> 1;
        }

        return count;
    }
}
