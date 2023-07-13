class Solution {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        f(root);
        return ans;

    }

    int f(TreeNode root) {
        if (root == null)
            return 0;
        int left = f(root.left);
        int right = f(root.right);
        ans = Math.max(left + right, ans);
        return 1 + Math.max(left, right);
    }
}