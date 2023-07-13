class Solution {
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = (int) 1e9;
        f(root);
        return ans;
    }

    int[] f(TreeNode root) {
        if (root == null)
            return new int[] { -(int) 1e9, (int) 1e9 };
        int l[] = f(root.left);
        int r[] = f(root.right);
        int min = Math.min(root.val - l[0], r[1] - root.val);
        ans = Math.min(ans, min);
        return new int[] { Math.max(root.val, r[0]), Math.min(root.val, l[1]) };
    }
}