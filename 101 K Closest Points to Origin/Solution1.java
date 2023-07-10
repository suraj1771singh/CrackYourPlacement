import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist(points[b]) - dist(points[a]));
        int n = points.length;
        for (int i = 0; i < points.length; i++) {
            if (pq.size() < k) pq.add(i);
            else {
                if (dist(points[pq.peek()]) > dist(points[i])) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        int res[][] = new int[k][2];
        int ind = 0;
        while (!pq.isEmpty()) res[ind++] = points[pq.poll()];
        return res;

    }
    int dist(int p[]) { return (int) Math.pow(p[0], 2) + (int) Math.pow(p[1], 2);}
}
//Time complexity : O(k*logk)