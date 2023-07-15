import java.util.*;

class Solution {
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        dfs(target, k);
        f(root, target, k);
        return res;
    }

    int f(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;
        if (root == target)
            return 0;
        int left = 1 + f(root.left, target, k);
        if (left > 0) {
            if (left == k)
                res.add(root.val);
            else
                dfs(root.right, k - left - 1);
        }
        int right = 1 + f(root.right, target, k);
        if (right > 0) {
            if (right == k)
                res.add(root.val);
            else
                dfs(root.left, k - right - 1);
        }
        return Math.max(left, right) == 0 ? -1 : Math.max(left, right);
    }

    void dfs(TreeNode root, int k) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            res.add(root.val);
            return;
        }
        dfs(root.left, k - 1);
        dfs(root.right, k - 1);
    }
}