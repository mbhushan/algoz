/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/569/
 */

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        for (int i=1; i<=10; i++) {
            System.out.println(i + ": " + cs.climbStairs(i));
        }
    }

    public int climbStairs(int n) {
        if (n <= 0 || n == 1 || n == 2) {
            return n;
        }
        int ans = 1;
        int prev = 1;
        int curr = 1;
        for (int i=2; i<=n; i++) {
            ans = prev + curr;
            prev = curr;
            curr = ans;
        }
        return ans;
    }
}
