import java.util.*;

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        int map[] = new int[n];
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int cnt = 0;
        int ttl_profit = 0;
        for (Job it : arr) {
            int id = it.id - 1;
            int deadline = it.deadline - 1;
            while (deadline >= 0) {
                if (map[deadline] == 0) {
                    map[deadline] = it.profit;
                    cnt++;
                    ttl_profit += it.profit;
                    break;
                }
                deadline--;
            }
        }
        return new int[] { cnt, ttl_profit };

    }
}
// Time complexity : O(n*t) : t = avg(deadline)