//    MEMOISATION
class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer dp[][][] = new Integer[prices.length + 1][2][k + 1];
        return f(0, 1, k, prices, dp);

    }

    public int f(int ind, int buy, int k, int[] prices, Integer[][][] dp) {
        if (ind == prices.length)
            return 0;
        if (k == 0)
            return 0;
        if (dp[ind][buy][k] != null)
            return dp[ind][buy][k];
        int profit = 0;
        if (buy == 1) {
            // either buy or skip
            profit = Math.max(-prices[ind] + f(ind + 1, 0, k, prices, dp), f(ind + 1, 1, k, prices, dp));
        } else {
            // sell or skip
            profit = Math.max(prices[ind] + f(ind + 1, 1, k - 1, prices, dp), f(ind + 1, 0, k, prices, dp));
        }
        return dp[ind][buy][k] = profit;

    }
}