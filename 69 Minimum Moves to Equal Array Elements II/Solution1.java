import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = nums[0], h = nums[n - 1];
        long ans = getCost(l, nums);

        while (l <= h) {
            int mid = (l + h) / 2;
            long cost1 = getCost(mid, nums);
            long cost2 = getCost(mid + 1, nums);
            ans = Math.min(ans, Math.min(cost1, cost2));
            if (cost2 > cost1)
                h = mid - 1;
            else
                l = mid + 1;

        }
        return (int) ans;
    }

    long getCost(int x, int a[]) {
        long cost = 0;
        for (int num : a)
            cost += Math.abs(x - num);
        return cost;
    }
}
// Time complexity : O(n*logn)