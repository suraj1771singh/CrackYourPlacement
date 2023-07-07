class Solution {
    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        if (M > N)
            return -1;
        int l = (int) 1e9;
        int h = 0;
        int ans = -1;
        for (int num : A) {
            l = Math.min(l, num);
            h += num;
        }
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isValid(mid, A, M)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    static boolean isValid(int x, int a[], int m) {
        int cnt = 1;
        int sum = 0;
        for (int num : a) {
            if (num > x)
                return false;
            if (sum + num > x) {
                sum = num;
                cnt++;
            } else
                sum += num;
        }
        return cnt <= m;
    }
};