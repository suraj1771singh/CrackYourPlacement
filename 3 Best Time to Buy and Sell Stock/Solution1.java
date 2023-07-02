class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int num : prices) {
            min = Math.min(min, num);
            ans = Math.max(ans, num - min);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)