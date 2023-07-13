class Solution {
    public boolean isBalanced(TreeNode root) {
        int h = f(root);
        return h == -1 ? false : true;
    }

    int f(TreeNode root) {
        if (root == null)
            return 0;
        int left = f(root.left);
        if (left == -1)
            return -1;
        int right = f(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? 1 + Math.max(left, right) : -1;
    }
}