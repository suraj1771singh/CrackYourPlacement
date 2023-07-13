import java.util.*;

class GFG {
    static Set<Integer> set;

    public static boolean isDeadEnd(Node root) {
        set = new HashSet<>();
        set.add(0);
        return inorder(root);
    }

    static boolean inorder(Node root) {
        if (root == null)
            return false;

        set.add(root.data);
        if (set.contains(root.data - 1) && set.contains(root.data + 1))
            return true;
        return inorder(root.left) || inorder(root.right);

    }
}
// Time complexity : O(n)
// Space complexity : O(n)