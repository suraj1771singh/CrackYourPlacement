class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return f(root, low, high);
    }

    int f(TreeNode root, int l, int h) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.val < l) {
            sum = f(root.right, l, h);
        } else if (root.val > h) {
            sum = f(root.left, l, h);
        } else {
            sum += root.val;
            sum += f(root.left, l, h) + f(root.right, l, h);
        }
        return sum;
    }
}