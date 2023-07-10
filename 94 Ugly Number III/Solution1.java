//Dynamic programing 
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        int c1 = 0, c2 = 0, c3 = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(a * dp[c1], Math.min(b * dp[c2], c * dp[c3]));
            if (dp[i] == a * dp[c1])
                c1++;
            if (dp[i] == b * dp[c2])
                c2++;
            if (dp[i] == c * dp[c3])
                c3++;
        }
        return dp[n - 1];
    }
}
// Time complexity : O(n);
