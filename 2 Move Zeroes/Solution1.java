class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                swap(i, ++j, nums);
        }
    }

    void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// Time complexity : O(n)
// Space complexit : O(1)