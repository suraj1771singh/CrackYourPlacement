class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[] = new Boolean[nums.length];
        return f(0, nums, dp);
    }

    boolean f(int ind, int[] nums, Boolean dp[]) {
        if (ind >= nums.length - 1)
            return true;
        if (dp[ind] != null)
            return dp[ind];
        for (int i = ind + 1; i <= ind + nums[ind]; i++) {
            if (f(i, nums, dp))
                return dp[ind] = true;
        }
        return dp[ind] = false;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)