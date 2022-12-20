public class BuySellStock2 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] P) {
        if (P == null || P.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i=1; i<P.length; i++) {
            if (P[i] > P[i-1]) {
                profit += (P[i] - P[i-1]);
            }
        }
        return profit;
    }
}
