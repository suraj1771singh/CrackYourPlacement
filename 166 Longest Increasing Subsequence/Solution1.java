class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n + 1][n + 1];
        return f(0, -1, nums, dp);
    }

    int f(int curr, int prev, int a[], Integer dp[][]) {
        if (curr == a.length)
            return 0;
        if (dp[curr][prev + 1] != null)
            return dp[curr][prev + 1];
        int p = 0, np = 0;
        if (prev == -1 || a[curr] > a[prev])
            p = 1 + f(curr + 1, curr, a, dp);

        np = f(curr + 1, prev, a, dp);
        return dp[curr][prev + 1] = Math.max(p, np);
    }

}
// Time complexity : O(n^2)