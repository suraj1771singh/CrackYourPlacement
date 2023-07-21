class Solution {
    public int maxProduct(int[] a) {
        int ans = -(int) 1e9, prod = 0;
        for (int i = 0; i < a.length; i++) {
            prod = prod == 0 ? a[i] : prod * a[i];
            ans = Math.max(ans, prod);
        }
        prod = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            prod = prod == 0 ? a[i] : prod * a[i];
            ans = Math.max(ans, prod);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)