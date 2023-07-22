import java.util.*;

class Solution {
    int moves[] = { -1, 0, 1 };
    Map<Integer, Integer> map;

    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++)
            map.put(stones[i], i);
        Boolean dp[][] = new Boolean[n][n + 1];
        return f(0, 0, stones, dp);
    }

    boolean f(int ind, int k, int[] a, Boolean dp[][]) {
        if (ind == a.length - 1)
            return true;
        if (dp[ind][k] != null)
            return dp[ind][k];
        for (int i : moves) {
            int nk = k + i;
            if (nk > 0) {
                int pos = nk + a[ind];
                if (map.containsKey(pos)) {
                    if (f(map.get(pos), nk, a, dp))
                        return dp[ind][k] = true;
                }
            }
        }
        return dp[ind][k] = false;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)