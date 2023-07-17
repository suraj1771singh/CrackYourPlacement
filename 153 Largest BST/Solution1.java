class Node {
    int data;
    Node left = null, right = null;

    Node(int a) {
        data = a;
    }
}

class Solution {

    static int ans;

    static int largestBst(Node root) {
        ans = 0;
        f(root);
        return ans;
    }

    static int[] f(Node root) {
        if (root == null)
            return new int[] { -(int) 1e9, (int) 1e9, 0 };
        int l[] = f(root.left);
        int r[] = f(root.right);
        if (l[2] == -1 || r[2] == -1)
            return new int[] { -1, -1, -1 };
        int cnt = 1 + l[2] + r[2];
        if (root.data > l[0] && root.data < r[1]) {
            ans = Math.max(ans, cnt);
            return new int[] { Math.max(root.data, r[0]), Math.min(root.data, l[1]), cnt };
        } else {
            return new int[] { -1, -1, -1 };
        }

    }

}