public class RevInt {

    public static void main(String[] args) {
        RevInt ri = new RevInt();
        int [] A = {123, 420, -123};
        for (int i=0; i<A.length; i++) {
            System.out.println(ri.reverse(A[i]));
        }
    }

    public int reverse(int x) {
        if(x == Integer.MIN_VALUE)
            return 0;
        int ans = 0;
        int sign = 1;
        if (x < 0){
            sign = -1;
            x = -x;
        }
        while (x > 0) {
            ans = ans*10 + x%10;
            x = x/10;
        }

        return ans*sign;

    }
}
