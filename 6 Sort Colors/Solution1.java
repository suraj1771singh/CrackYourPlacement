class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(high, mid, nums);
                high--;
            } else
                mid++;
        }
    }

    void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}