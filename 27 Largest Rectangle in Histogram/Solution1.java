
//So basically each slab of rectangle can extend to its next smaller slab in left and right
//Think about a datastructure that let you find next smaller in contant amount of time
//dereasing monotonic stack
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int a[] = new int[n];
        int b[] = new int[n];
        Arrays.fill(a, n);
        Arrays.fill(b, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] > h[i])
                a[st.pop()] = i;
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] > h[i])
                b[st.pop()] = i;
            st.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int area = (a[i] - b[i] - 1) * h[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)