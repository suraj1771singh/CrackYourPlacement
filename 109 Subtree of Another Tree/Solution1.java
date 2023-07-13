class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (root.val == subRoot.val) {
            if (check(root, subRoot))
                return true;
        }
        if (isSubtree(root.left, subRoot))
            return true;
        if (isSubtree(root.right, subRoot))
            return true;
        return false;
    }

    boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null)
            return node2 == null;
        if (node2 == null)
            return node1 == null;
        if (node1.val != node2.val)
            return false;
        if (!check(node1.left, node2.left))
            return false;
        if (!check(node1.right, node2.right))
            return false;
        return true;

    }
}