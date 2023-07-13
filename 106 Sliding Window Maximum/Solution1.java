import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.add(i);
            while (q.peekFirst() <= i - k)
                q.pollFirst();
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[q.peekFirst()];
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)