class Solution {
    int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0, dist = startFuel, ind = 0;
        while (true) {
            if (dist >= target)
                return res;
            while (ind < stations.length && dist >= stations[ind][0])
                pq.add(stations[ind++][1]);
            if (pq.isEmpty())
                return -1;
            dist += pq.poll();
            res++;
        }
    }
}
// Time complexity : O(n*logn)