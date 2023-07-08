import java.util.*;

public class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int l = 0, h = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isValid(mid, stalls, k)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;
    }

    static boolean isValid(int limit, int[] stalls, int k) {
        int cnt = 1;
        int last = 0;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[last] >= limit) {
                last = i;
                cnt++;
            }
        }
        return cnt >= k;
    }
}