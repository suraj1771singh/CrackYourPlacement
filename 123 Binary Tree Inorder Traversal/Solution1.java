class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    void f(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        f(root.left, res);
        res.add(root.val);
        f(root.right, res);
    }
}