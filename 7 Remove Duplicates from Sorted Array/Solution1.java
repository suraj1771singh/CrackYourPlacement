class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ind = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[ind]) {
                ind++;
                swap(ind, i, nums);

            }
        }
        return ind + 1;
    }

    void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// Time complexity: O(n)
// Space complexity : O(1)