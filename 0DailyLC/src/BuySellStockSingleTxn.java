public class BuySellStockSingleTxn {
    public static void main(String[] args) {
        BuySellStockSingleTxn bs = new BuySellStockSingleTxn();
        int [] A = {7,1,5,3,6,4};
        System.out.println(bs.maxProfit(A));

    }

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = prices[0];
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxprofit) {
                maxprofit = profit;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxprofit;
    }
}
