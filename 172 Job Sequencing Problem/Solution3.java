
//-------USING DSU
import java.util.*;

class Solution {

    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int cnt = 0, sum = 0;
        Dsu dsu = new Dsu(n + 1);
        for (Job it : arr) {
            int availabelSlot = dsu.find(it.deadline);
            if (availabelSlot > 0) {
                dsu.union(availabelSlot - 1, availabelSlot);
                sum += it.profit;
                cnt++;
            }
        }
        return new int[] { cnt, sum };
    }
}

// Time complexity : O(n*logn)
// Space complexity : O(n)
class Dsu {
    int parent[];

    Dsu(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);
        if (p1 == p2)
            return;
        parent[p2] = p1;
    }
}