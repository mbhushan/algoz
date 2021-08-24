public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
    }

    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = 10*rev + x%10;
            x = x / 10;
            if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int)rev;
    }
}
