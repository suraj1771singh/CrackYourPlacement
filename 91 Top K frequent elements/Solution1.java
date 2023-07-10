import java.util.*;

//Bucket sort

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer> bucket[] = new ArrayList[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null)
                bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }
        int res[] = new int[k];
        int ind = 0;
        for (int i = n; i >= 0; i--) {
            if (bucket[i] == null)
                continue;
            for (int num : bucket[i]) {
                res[ind++] = num;
                if (ind >= k)
                    return res;
            }
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)