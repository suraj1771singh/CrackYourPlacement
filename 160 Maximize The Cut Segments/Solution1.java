class Solution {
    int X;
    int Y;
    int Z;

    public int maximizeCuts(int n, int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
        Integer dp[] = new Integer[n + 1];
        int ans = f(n, dp);
        return ans == -1 ? 0 : ans;
    }

    int f(int n, Integer dp[]) {
        if (n <= 0)
            return n == 0 ? 0 : -1;
        if (dp[n] != null)
            return dp[n];
        int a = f(n - X, dp);
        int b = f(n - Y, dp);
        int c = f(n - Z, dp);
        int res = Math.max(a, Math.max(b, c));
        if (res == -1)
            return dp[n] = res;
        else
            return dp[n] = 1 + res;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)