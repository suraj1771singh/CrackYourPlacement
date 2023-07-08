class Solution {

    public int mctFromLeafValues(int[] arr) {

        int n = arr.length;
        Integer dp[][] = new Integer[n][n];
        return f(0, n - 1, arr, dp);

    }

    int f(int l, int h, int[] arr, Integer dp[][]) {
        int res = (int) 1e9;
        if (l >= h)
            return 0;
        if (dp[l][h] != null)
            return dp[l][h];
        for (int i = l; i < h; i++) {
            // break at i
            int left = i;
            int right = i + 1;
            int left_mx = arr[i];
            int right_mx = arr[i + 1];
            while (left >= l)
                left_mx = Math.max(left_mx, arr[left--]);
            while (right <= h)
                right_mx = Math.max(right_mx, arr[right++]);
            res = Math.min(res, left_mx * right_mx + f(l, i, arr, dp) + f(i + 1, h, arr, dp));
        }
        return dp[l][h] = res;
    }
}
// Time complexity : O(n^3)
// Space complexity : O(n^2)