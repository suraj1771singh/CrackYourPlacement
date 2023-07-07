import java.util.Arrays;

class Solution {
    int ceiling(int a[], int n, int x) {
        Arrays.sort(a);
        int l = 0, h = n - 1;
        int ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (x < a[mid])
                h = mid - 1;
            else {
                ans = mid;
                l = mid - 1;
            }
        }
        return ans;
    }

}
// Time complexity : O(nlogn)