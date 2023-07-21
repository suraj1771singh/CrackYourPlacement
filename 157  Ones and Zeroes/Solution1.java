class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int cnt[][] = new int[len][2];
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (char c : strs[i].toCharArray())
                if (c == '0')
                    j++;
            cnt[i] = new int[] { j, strs[i].length() - j };
        }
        Integer dp[][][] = new Integer[len][m + 1][n + 1];
        return f(len - 1, m, n, cnt, dp);
    }

    int f(int ind, int m, int n, int cnt[][], Integer dp[][][]) {
        if (ind < 0)
            return 0;

        if (dp[ind][m][n] != null)
            return dp[ind][m][n];

        int n_m = m - cnt[ind][0];
        int n_n = n - cnt[ind][1];

        if (n_m >= 0 && n_n >= 0)
            return dp[ind][m][n] = Math.max(1 + f(ind - 1, n_m, n_n, cnt, dp), f(ind - 1, m, n, cnt, dp));
        else
            return dp[ind][m][n] = f(ind - 1, m, n, cnt, dp);
    }
}
// Time complexity : O(len*n*m)
// Space complexity : O(len*n*m)