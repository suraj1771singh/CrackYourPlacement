class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int ind = Math.abs(nums[i]);
            if (ind < n) {
                if (nums[ind] == 0) {
                    nums[ind] = -(int) 1e9;
                    nums[0] = -1;
                } else
                    nums[ind] = nums[ind] * -1;
            }
        }
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0)
                return i;
        }
        return n;
    }
}