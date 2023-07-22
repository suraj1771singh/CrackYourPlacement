
class NumMatrix {
    int dp[][];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1] + matrix[i][j];
            }
        }
    }

    // O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row2 + 1][col2 + 1];
        return ans;
    }
}
