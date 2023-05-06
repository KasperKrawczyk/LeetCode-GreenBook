public class BestTimeToBuyAndSellStock1 {

    // time O(n), space O(1)
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        int sell;
        for (int i = 1; i < prices.length; i++) {
            sell = prices[i];
            profit = Math.max(profit, sell - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }

}
