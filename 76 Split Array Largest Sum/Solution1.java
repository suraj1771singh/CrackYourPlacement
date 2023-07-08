class Solution {
    public int splitArray(int[] nums, int k) {
        long l = 0, h = 0;
        for (int i : nums) {
            l = Math.min(l, i);
            h += i;
        }
        long ans = 0;
        while (l <= h) {
            long mid = (l + h) / 2;
            if (isValid(mid, k, nums)) {
                h = mid - 1;
                ans = mid;
            } else
                l = mid + 1;
        }
        return (int) ans;
    }

    boolean isValid(long x, int k, int a[]) {
        int cnt = 1;
        long sum = 0;
        for (int i : a) {
            if (i > x)
                return false;
            if (sum + i > x) {
                sum = i;
                cnt++;
            } else
                sum += i;
        }
        return cnt <= k;
    }
}
// Time complexity : O(n*logn)