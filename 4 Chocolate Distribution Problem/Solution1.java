import java.util.Arrays;

class Solution {
    static int findMinDiff(int arr[], int n, int m) {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = m - 1; i < n; i++) {
            ans = Math.min(ans, arr[i] - arr[i - m + 1]);
        }
        return ans;
    }
}
// Time complexity : O(n*logn)
// Space complexity : O(1)