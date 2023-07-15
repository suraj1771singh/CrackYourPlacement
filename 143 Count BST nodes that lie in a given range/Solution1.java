class Solution {

    int getCount(Node root, int l, int h) {
        int ans = 0;
        while (root != null) {
            if (root.data < l)
                root = root.right;
            else if (root.data > h)
                root = root.left;
            else {
                ans = 1;
                ans += getCount(root.left, l, h);
                ans += getCount(root.right, l, h);
                break;
            }
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(h)