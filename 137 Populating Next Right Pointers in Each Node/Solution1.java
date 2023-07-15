import java.util.*;;

class Solution {
    Map<Integer, Node> map;

    public Node connect(Node root) {
        map = new HashMap<>();
        f(root, 0);
        return root;
    }

    void f(Node root, int d) {
        if (root == null)
            return;
        if (map.containsKey(d))
            map.get(d).next = root;
        map.put(d, root);
        f(root.left, d + 1);
        f(root.right, d + 1);
    }
}