class Solution {
    int ans;
    int cnt;

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        cnt = k;
        f(root);
        return ans;
    }

    void f(TreeNode root) {
        if (root == null)
            return;
        f(root.left);
        cnt--;
        if (cnt == 0) {
            ans = root.val;
            return;
        }

        f(root.right);
    }
}