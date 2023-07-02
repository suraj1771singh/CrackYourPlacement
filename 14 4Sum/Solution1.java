import java.util.*;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> fourSum(int[] nums, int target) {

        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                twosum(j + 1, n - 1, nums[i], nums[j], target, nums);
            }
        }
        return res;
    }

    void twosum(int l, int h, int num1, int num2, int target, int[] nums) {
        int lastlow = -1, n = nums.length;
        while (l < h) {
            long sum = (long) num1 + (long) num2 + (long) nums[l] + (long) nums[h];
            if (sum == target) {
                res.add(Arrays.asList(num1, num2, nums[l], nums[h]));
                lastlow = nums[l];
                while (l < n && lastlow == nums[l])
                    l++;
            } else if (sum > target)
                h--;
            else
                l++;
        }
    }
}
// Time complexity : O(n^3);
// Space complexity : O(1)