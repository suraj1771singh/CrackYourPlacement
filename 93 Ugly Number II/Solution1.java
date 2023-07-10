class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        int cnt = 0;
        long mini = 0;
        while (cnt != n) {
            long a = q.poll();
            if (mini == a)
                continue;
            mini = a;
            cnt++;
            q.add(mini * 2);
            q.add(mini * 3);
            q.add(mini * 5);

        }
        return (int) mini;
    }
}