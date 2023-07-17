import java.util.*;

class Solution {
    int cnt[];
    int ans[];

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        cnt = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        f(0, adj, 0, new boolean[n]);
        dfs(0, n, adj, new boolean[n]);
        return ans;
    }

    void dfs(int node, int n, List<List<Integer>> adj, boolean seen[]) {
        seen[node] = true;
        for (int child : adj.get(node)) {
            if (child == node || seen[child])
                continue;
            ans[child] = ans[node] - cnt[child] + (n - cnt[child]);
            dfs(child, n, adj, seen);
        }
    }

    int f(int node, List<List<Integer>> adj, int h, boolean seen[]) {
        int res = 1;
        ans[0] += h;
        seen[node] = true;
        for (int child : adj.get(node)) {
            if (node == child || seen[child])
                continue;
            res += f(child, adj, h + 1, seen);
        }
        return cnt[node] = res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)