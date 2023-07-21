class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer dp[][] = new Integer[n][amount + 1];
        int ans = f(n - 1, amount, coins, dp);
        return ans == (int) 1e9 ? -1 : ans;
    }

    int f(int ind, int amount, int[] coin, Integer dp[][]) {
        if (ind == 0)
            return amount % coin[ind] == 0 ? amount / coin[ind] : (int) 1e9;
        if (dp[ind][amount] != null)
            return dp[ind][amount];
        int p = (int) 1e9, np = (int) 1e9;

        if (amount - coin[ind] >= 0)
            p = 1 + f(ind, amount - coin[ind], coin, dp);
        np = f(ind - 1, amount, coin, dp);
        return dp[ind][amount] = Math.min(p, np);
    }
}
// Time complexity : O(n*amount)
