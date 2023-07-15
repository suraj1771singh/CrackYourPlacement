import java.util.*;

class Solution {
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        f(root, 0);
        return res;
    }

    void f(TreeNode root, int d) {
        if (root == null)
            return;
        if (d == res.size())
            res.add(root.val);
        f(root.right, d + 1);
        f(root.left, d + 1);
    }

}
// Time complexity : O(n)
// Space complexity : O(1)