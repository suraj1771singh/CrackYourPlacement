import java.util.*;

class Solution {
    Map<Integer, List<int[]>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        f(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            List<int[]> a = map.get(key);
            Collections.sort(a, (i, j) -> i[1] == j[1] ? i[0] - j[0] : i[1] - j[1]);
            List<Integer> b = new ArrayList<>();
            for (int i[] : a)
                b.add(i[0]);

            res.add(b);
        }
        return res;

    }

    void f(TreeNode node, int r, int c) {
        if (node == null)
            return;
        if (!map.containsKey(c))
            map.put(c, new ArrayList<>());
        map.get(c).add(new int[] { node.val, r });
        f(node.left, r + 1, c - 1);
        f(node.right, r + 1, c + 1);
    }
}