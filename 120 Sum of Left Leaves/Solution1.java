class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return f(root, false);
    }

    int f(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            if (isLeft)
                return root.val;
            else
                return 0;
        }
        int sum = 0;
        sum += f(root.left, true);
        sum += f(root.right, false);
        return sum;
    }
}