class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return f(root, targetSum);
    }

    boolean f(TreeNode root, int sum) {
        if (root.left == null && root.right == null)
            return sum == root.val;
        if (root.left != null && f(root.left, sum - root.val))
            return true;
        if (root.right != null && f(root.right, sum - root.val))
            return true;
        return false;

    }
}