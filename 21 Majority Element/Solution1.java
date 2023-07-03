class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], n = nums.length, vote = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate)
                vote++;
            else {
                vote--;
                if (vote == 0) {
                    candidate = nums[i];
                    vote = 1;
                }
            }
        }
        // check if posssible candidate have highest vote count or not;
        vote = 0;
        for (int num : nums)
            if (num == candidate)
                vote++;
        if (vote > n / 2)
            return candidate;
        else
            return -1;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)