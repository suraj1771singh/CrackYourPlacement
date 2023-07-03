
//---Giving TLE
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        int presum[] = new int[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++)
            presum[i] = presum[i - 1] + nums[i];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = i == 0 ? presum[j] : presum[j] - presum[i - 1];
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

}
// Time complexity : O(n^2)
// Space complexity : O(n)