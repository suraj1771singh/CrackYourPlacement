import java.util.*;

class Solution {
    List<Integer> list;
    int ans;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        list = new ArrayList<>();
        ans = 1;
        f(root, 0, 1);
        return ans;
    }

    void f(TreeNode root, int d, int ind) {
        if (root == null)
            return;
        if (d == list.size())
            list.add(ind);
        ans = Math.max(ans, ind - list.get(d) + 1);
        f(root.left, d + 1, ind * 2);
        f(root.right, d + 1, ind * 2 + 1);
    }
}
// Time complexity : O(n)
// Space complexity : O(h)