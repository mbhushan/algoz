import java.nio.Buffer;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
 */
public class BestTimeBuySellStock {
    public static void main(String[] args) {
        BestTimeBuySellStock bs = new BestTimeBuySellStock();

        int [] P = {7,1,5,3,6,4};
        int profit = bs.maxProfit(P);
        System.out.println("profit: " + profit);
    }

    public int maxProfit(int[] P) {
        if (P == null || P.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i=1; i<P.length; i++) {
            if (P[i] > P[i-1]) {
                maxProfit += (P[i] - P[i-1]);
            }
        }
        return maxProfit;
    }


}
