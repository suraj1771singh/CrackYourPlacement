import java.util.*;

class Solution {
    Map<Integer, Integer> map;

    public int deleteAndEarn(int[] nums) {
        map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int n = map.size();
        int a[] = new int[n];
        int ind = 0;
        for (int key : map.keySet())
            a[ind++] = key;
        Arrays.sort(a);
        Integer dp[] = new Integer[n];
        return f(0, a, dp);
    }

    int f(int ind, int nums[], Integer dp[]) {
        int n = nums.length;
        if (ind >= n)
            return 0;
        if (dp[ind] != null)
            return dp[ind];
        int del = nums[ind] * map.get(nums[ind]) + f(find(ind, nums), nums, dp);
        int notdel = f(ind + 1, nums, dp);
        return dp[ind] = Math.max(del, notdel);
    }

    int find(int i, int a[]) {
        int x = a[i] + 1;
        while (i < a.length && a[i] <= x)
            i++;
        return i;
    }
}
// Time complexity : O(n*logn)