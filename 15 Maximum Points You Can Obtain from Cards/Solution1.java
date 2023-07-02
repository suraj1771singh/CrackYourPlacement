class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int w = n - k;

        int sum = 0;
        for (int i = 0; i < w; i++)
            sum += cardPoints[i];
        int ans = sum;

        for (int i = w; i < n; i++) {
            sum += cardPoints[i];
            sum -= cardPoints[i - w];
            ans = Math.min(ans, sum);
        }

        int ttl = 0;
        for (int num : cardPoints)
            ttl += num;
        return ttl - ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)