class Solution {
    public int minCameraCover(TreeNode root) {
        Integer dp[][][] = new Integer[1001][2][2];
        return f(root, 0, 0, 1, dp);
    }

    int f(TreeNode curr, int isMonitored, int isCamera, int ind, Integer dp[][][]) {
        if (curr == null)
            return 0;
        if (dp[ind][isMonitored][isCamera] != null)
            return dp[ind][isMonitored][isCamera];
        if (isCamera == 1) {
            int a = 1 + f(curr.left, 1, 0, ind * 2, dp) + f(curr.right, 1, 0, ind * 2 + 1, dp);
            return dp[ind][isMonitored][isCamera] = a;
        } else if (isMonitored == 1) {
            // install camera
            int a = 1 + f(curr.left, 1, 0, ind * 2, dp) + f(curr.right, 1, 0, ind * 2 + 1, dp);
            // not install camera
            int b = 1 + f(curr.left, 0, 0, ind * 2, dp) + f(curr.right, 0, 0, ind * 2 + 1, dp);
            return dp[ind][isMonitored][isCamera] = Math.min(a, b);
        } else {
            // not monitored, no camera
            // add camera to it self
            int a = 1 + f(curr.left, 1, 0, ind * 2, dp) + f(curr.right, 1, 0, ind * 2 + 1, dp);
            // add camera to its child
            int b = curr.left == null ? (int) 1e9
                    : f(curr.left, 0, 1, ind * 2, dp) + f(curr.right, 0, 0, ind * 2 + 1, dp);
            int c = curr.right == null ? (int) 1e9
                    : f(curr.left, 0, 0, ind * 2, dp) + f(curr.right, 0, 1, ind * 2 + 1, dp);
            return dp[ind][isMonitored][isCamera] = Math.min(a, Math.min(b, c));
        }
    }

}