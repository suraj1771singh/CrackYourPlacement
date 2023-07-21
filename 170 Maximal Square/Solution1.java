class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                else if (matrix[i][j] == '1')
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}