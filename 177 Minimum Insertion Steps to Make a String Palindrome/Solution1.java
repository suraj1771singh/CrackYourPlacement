class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        Integer dp[][] = new Integer[n][n];
        return f(0, n - 1, s, dp);
    }

    int f(int l, int h, String s, Integer dp[][]) {
        if (l >= h)
            return 0;
        if (dp[l][h] != null)
            return dp[l][h];
        if (s.charAt(l) == s.charAt(h))
            return dp[l][h] = f(l + 1, h - 1, s, dp);
        else
            return dp[l][h] = 1 + Math.min(f(l, h - 1, s, dp), f(l + 1, h, s, dp));
    }
}
// Time complexity : O(n^2)