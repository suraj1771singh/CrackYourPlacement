import java.util.*;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue; // skip duplicates
            twosum(i + 1, n - 1, nums[i], nums);
        }
        return res;
    }

    void twosum(int l, int h, int num1, int[] nums) {
        int lastlow = -1, n = nums.length;
        while (l < h) {
            int sum = num1 + nums[l] + nums[h];
            if (sum == 0) {
                res.add(Arrays.asList(num1, nums[l], nums[h]));
                lastlow = nums[l];
                while (l < n && lastlow == nums[l])
                    l++;
            } else if (sum > 0)
                h--;
            else
                l++;
        }
    }
}
// Time complexity : O(n^2)
// Space complexity : O(1)