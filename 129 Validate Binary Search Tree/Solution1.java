class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBst(TreeNode node, long l_bound, long r_bound) {
        if (node == null)
            return true;
        if (node.val <= l_bound || node.val >= r_bound)
            return false;
        return isBst(node.left, l_bound, node.val) && isBst(node.right, node.val, r_bound);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)