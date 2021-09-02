/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/572/
 */

public class BuySellStockDP {

    public static void main(String[] args) {
        BuySellStockDP bs = new BuySellStockDP();
        int [] P = {7,1,5,3,6,4};
        int ans = bs.maxProfit(P);
        System.out.println("ans: " + ans);
    }

    public int maxProfit(int[] P) {
        if (P == null || P.length <= 1) {
            return 0;
        }
        int minSoFar = P[0];
        int maxDiff = 0;
        for (int x: P) {
            if (x < minSoFar) {
               minSoFar = x;
            }
            int diff = x - minSoFar;
            maxDiff = diff > maxDiff ? diff: maxDiff;
        }
        return maxDiff;
    }
}


