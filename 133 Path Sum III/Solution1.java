import java.util.*;

class Solution {
    int ans;

    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        f(root, 0, map, targetSum);
        return ans;
    }

    void f(TreeNode root, long sum, Map<Long, Integer> map, int targetSum) {
        if (root == null)
            return;
        sum += root.val;
        if (map.containsKey(sum - targetSum)) {
            ans += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        f(root.left, sum, map, targetSum);
        f(root.right, sum, map, targetSum);
        if (map.get(sum) == 1)
            map.remove(sum);
        else
            map.put(sum, map.get(sum) - 1);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)