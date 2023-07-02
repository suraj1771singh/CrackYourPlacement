class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int ind = Math.abs(num) - 1;
            if (nums[ind] < 0)
                return ind + 1;
            else
                nums[ind] = nums[ind] * -1;
        }
        return -1;
    }
}
// Time complexity: O(n);
// Spac complexity :O(1)