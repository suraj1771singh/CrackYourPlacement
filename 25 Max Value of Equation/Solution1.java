import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int ans = -(int) 1e9;
        for (int[] point : points) {
            int x2 = point[0];
            int y2 = point[1];
            while (!pq.isEmpty() && pq.peek()[1] + k < x2)
                pq.poll();
            if (!pq.isEmpty())
                ans = Math.max(ans, pq.peek()[0] + x2 + y2);
            pq.add(new int[] { y2 - x2, x2 });
        }
        return ans;
    }
}
// Time complexity : O(n*logn)