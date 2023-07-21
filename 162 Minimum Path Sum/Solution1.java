class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Integer dp[][] = new Integer[n][m];
        return f(0, 0, n, m, grid, dp);
    }

    int f(int i, int j, int n, int m, int a[][], Integer dp[][]) {
        if (i == n - 1 && j == m - 1)
            return a[i][j];
        if (dp[i][j] != null)
            return dp[i][j];
        int right = j + 1 < m ? f(i, j + 1, n, m, a, dp) : (int) 1e9;
        int down = i + 1 < n ? f(i + 1, j, n, m, a, dp) : (int) 1e9;
        int min = Math.min(right, down);
        return dp[i][j] = min == (int) 1e9 ? min : a[i][j] + min;
    }
}
// Time complexity : O(n*m)
// Space complexity : O(n*m)