package besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock3 {
    // time O(n), space O(1)
    public int maxProfit(int[] prices) {
        int trade1Buy = Integer.MAX_VALUE;
        int trade1Sell = 0;

        int trade2Buy = Integer.MAX_VALUE;
        int trade2Sell = 0;

        for (int i = 0; i < prices.length; i++) {
            trade1Buy = Math.min(trade1Buy, prices[i]);
            trade1Sell = Math.max(trade1Sell, prices[i] - trade1Buy);

            trade2Buy = Math.min(trade2Buy, prices[i] - trade1Sell);
            trade2Sell = Math.max(trade2Sell, prices[i] - trade2Buy);
        }
        return trade2Sell;
    }
}
