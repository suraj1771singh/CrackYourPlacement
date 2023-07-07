class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int left = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int right = mid + 1 >= n ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] >= right && nums[mid] >= left)
                return mid;
            else if (nums[mid] > right)
                h = mid - 1;
            else
                l = mid + 1;

        }
        return -1;
    }
}
// Time complexity : O(logn)