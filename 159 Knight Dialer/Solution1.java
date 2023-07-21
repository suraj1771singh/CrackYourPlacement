import java.util.*;

class Solution {
    final int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        List<int[]> next = new ArrayList<>();

        next.add(new int[] { 4, 6 });
        next.add(new int[] { 6, 8 });
        next.add(new int[] { 7, 9 });
        next.add(new int[] { 4, 8 });
        next.add(new int[] { 0, 3, 9 });
        next.add(new int[0]);
        next.add(new int[] { 0, 1, 7 });
        next.add(new int[] { 2, 6 });
        next.add(new int[] { 1, 3 });
        next.add(new int[] { 2, 4 });

        int ans = 0;
        Integer dp[][] = new Integer[n + 1][10];
        for (int i = 0; i < 10; i++)
            ans = (ans + f(n - 1, i, next, dp)) % MOD;
        return ans;
    }

    int f(int n, int num, List<int[]> a, Integer dp[][]) {
        if (n == 0)
            return 1;
        if (dp[n][num] != null)
            return dp[n][num];
        int res = 0;
        for (int nextnum : a.get(num))
            res = (res + f(n - 1, nextnum, a, dp)) % MOD;
        return dp[n][num] = res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)