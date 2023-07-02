class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return f(0, 1, prices, dp);
    }

    int f(int ind, int isBuy, int[] prices, Integer dp[][]) {
        if (ind >= prices.length)
            return 0;
        if (dp[ind][isBuy] != null)
            return dp[ind][isBuy];
        if (isBuy == 1)
            dp[ind][isBuy] = Math.max(-prices[ind] + f(ind + 1, 0, prices, dp), f(ind + 1, isBuy, prices, dp));

        else
            dp[ind][isBuy] = Math.max(prices[ind] + f(ind + 1, 1, prices, dp), f(ind + 1, isBuy, prices, dp));
        return dp[ind][isBuy];

    }
}
// Time complexity : O(n)
// Space complexity : O(n)