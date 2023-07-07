class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int p1[] = points[i];
            for (int j = i + 1; j < n; j++) {
                int p2[] = points[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int p3[] = points[k];

                    if ((p1[0] - p2[0]) * (p2[1] - p3[1]) == (p2[0] - p3[0]) * (p1[1] - p2[1]))
                        cnt++;

                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

}
// Time complexity : O(n^3)
