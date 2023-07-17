class Solution {
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        f(root);
        return ans;
    }

    int f(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(f(root.left), 0);
        int right = Math.max(f(root.right), 0);

        int mx = root.val + left + right;
        ans = Math.max(ans, mx);
        return root.val + Math.max(left, right);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)