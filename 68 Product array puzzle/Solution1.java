class Solution {
    public static long[] productExceptSelf(int nums[], int n) {

        long res[] = new long[n];
        long prod = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * prod;
            prod *= nums[i];
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)