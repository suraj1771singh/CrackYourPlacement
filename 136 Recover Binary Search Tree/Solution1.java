class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        // now swap first and second
        int temp = first.val;
        System.out.println(first.val);
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        // logic
        if (prev.val > root.val) {
            System.out.println("hii");
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}