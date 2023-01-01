public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        int n = 10;
        for (int i=0; i<=n; i++) {
            System.out.println(i + ": " + cs.climbStairs(i));
        }


    }

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        int ans = 0;
        for (int i=2; i<n; i++) {
            ans = a+b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
