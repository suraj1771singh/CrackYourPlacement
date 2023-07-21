class Solution {

    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m][n];
        return f(0, 0, m, n, dp);
    }

    int f(int i, int j, int m, int n, Integer dp[][]) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] != null)
            return dp[i][j];
        int right = j + 1 < n ? f(i, j + 1, m, n, dp) : 0;
        int down = i + 1 < m ? f(i + 1, j, m, n, dp) : 0;
        return dp[i][j] = right + down;
    }
}
// Time complexity : O(n*m)
// Space complexity : O(n*m)