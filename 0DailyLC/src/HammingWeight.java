public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hw = new HammingWeight();
        int x = 4294967293;

        System.out.println(hw.hammingWeight(7));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while( n > 0) {
            int x = n & 1;
            if (x == 1) ++count;
            n = n>>1;
        }
        return count;
    }
}
