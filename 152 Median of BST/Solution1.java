class Tree {
    static int ind;
    static float ans;
    static Node prev;

    public static float findMedian(Node root) {
        ans = 0;
        ind = 0;
        int countNodes = cnt(root);
        prev = null;
        f(root, countNodes);
        return ans;

    }

    static void f(Node root, int n) {
        if (root == null)
            return;

        f(root.left, n);

        if (ind == n / 2) {

            if (n % 2 == 0)
                ans = ((float) root.data + (float) prev.data) / 2;
            else
                ans = root.data;

        }
        ind++;
        prev = root;
        f(root.right, n);

    }

    static int cnt(Node root) {
        if (root == null)
            return 0;
        return 1 + cnt(root.left) + cnt(root.right);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)