class Solution {
    public int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        if (n == 1)
            return 0;
        Integer dp[][] = new Integer[n][k + 1];
        return f(1, k - nums[0], k, nums, dp);
    }

    int f(int ind, int sum, int k, int[] nums, Integer dp[][]) {
        if (ind == nums.length - 1) {
            if (sum - 1 - nums[ind] >= 0) {
                sum = sum - 1 - nums[ind];
                return 0;
            } else
                return (int) Math.pow(sum, 2);

        }
        if (dp[ind][sum] != null)
            return dp[ind][sum];
        if (sum - 1 - nums[ind] < 0)
            return dp[ind][sum] = (int) Math.pow(sum, 2) + f(ind + 1, k - nums[ind], k, nums, dp);

        int p = f(ind + 1, sum - nums[ind] - 1, k, nums, dp);
        int np = (int) Math.pow(sum, 2) + f(ind + 1, k - nums[ind], k, nums, dp);
        return dp[ind][sum] = Math.min(p, np);
    }
}