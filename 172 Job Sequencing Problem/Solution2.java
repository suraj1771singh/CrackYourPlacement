import java.util.*;;

class Solution {

    int[] JobScheduling(Job arr[], int n) {
        // sort according to deadline
        Arrays.sort(arr, (a, b) -> a.deadline - b.deadline);
        // Max : according to profit
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Job it : arr) {
            if (it.deadline > q.size())
                q.add(it.profit);
            else {
                if (q.peek() < it.profit) {
                    q.poll();
                    q.add(it.profit);
                }
            }
        }
        int cnt = q.size(), sum = 0;
        while (!q.isEmpty())
            sum += q.poll();

        return new int[] { cnt, sum };
    }
}
// Time complexity : O(n*logn)
// Space complexity : O(n)