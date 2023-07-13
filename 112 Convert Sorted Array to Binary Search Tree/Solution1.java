class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(0, nums.length - 1, nums);
    }

    TreeNode f(int l, int h, int[] nums) {
        if (l > h)
            return null;
        int mid = (l + h) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = f(l, mid - 1, nums);
        node.right = f(mid + 1, h, nums);
        return node;
    }

}