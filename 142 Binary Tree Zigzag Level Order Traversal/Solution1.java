import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean f = true;
        while (!q.isEmpty()) {
            int k = q.size();
            List<Integer> temp = new ArrayList<>();
            while (k-- > 0) {
                TreeNode node = f ? q.pollFirst() : q.pollLast();
                temp.add(node.val);
                if (f) {
                    if (node.left != null)
                        q.addLast(node.left);
                    if (node.right != null)
                        q.addLast(node.right);
                } else {

                    if (node.right != null)
                        q.addFirst(node.right);
                    if (node.left != null)
                        q.addFirst(node.left);
                }
            }
            res.add(temp);
            f = f ? false : true;
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)