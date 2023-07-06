import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0, n = matrix.length, m = matrix[0].length;
        int a[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++)
                a[k] = matrix[i][k] == '0' ? 0 : a[k] + 1;

            int area = getMaxArea(a);
            res = Math.max(res, area);
        }
        return res;
    }

    int getMaxArea(int a[]) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;

        int l[] = new int[n];
        int r[] = new int[n];

        Arrays.fill(l, -1);
        Arrays.fill(r, n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i])
                r[st.pop()] = i;
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] > a[i])
                l[st.pop()] = i;
            st.push(i);
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int area = (r[i] - l[i] - 1) * a[i];
            mx = Math.max(mx, area);
        }
        return mx;
    }
}
// Time complexity : O(n*m)