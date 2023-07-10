import java.util.*;

class Solution {
    public int furthestBuilding(int[] h, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = h.length;
        for (int i = 1; i < n; i++) {
            if (h[i] - h[i - 1] <= 0)
                continue;
            int jump = h[i] - h[i - 1];
            if (q.size() < ladders)
                q.add(jump);
            else {
                if (!q.isEmpty() && q.peek() > jump)
                    bricks -= jump;
                else {
                    q.add(jump);
                    bricks -= q.poll();
                }
            }
            if (bricks < 0)
                return i - 1;
        }
        return n - 1;
    }
}
// Time complexity : O(n*log(ladders))