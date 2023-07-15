class GfG {
    int ans;

    int findDist(Node root, int a, int b) {
        ans = 0;
        f(root, a, b);
        return ans;
    }

    int f(Node root, int a, int b) {
        if (root == null)
            return 0;
        int left = f(root.left, a, b);
        int right = f(root.right, a, b);
        if (root.data == a || root.data == b) {
            if (left != 0)
                ans = left;
            else if (right != 0)
                ans = right;
            else
                return 1;
        }
        if (left != 0 && right != 0)
            ans = left + right;
        else if (left != 0)
            return left + 1;
        else if (right != 0)
            return right + 1;
        return 0;
    }
}
// Time complexity : O(n)
// Space complexity : O(h)