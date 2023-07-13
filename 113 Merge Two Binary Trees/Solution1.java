class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return f(root1, root2);
    }

    TreeNode f(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return null;
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        TreeNode node = new TreeNode(node1.val + node2.val);
        node.left = f(node1.left, node2.left);
        node.right = f(node1.right, node2.right);
        return node;
    }
}