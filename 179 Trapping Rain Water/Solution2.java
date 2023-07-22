import java.util.*;

//-----------Using Monotonic Stack (Decreasing Stack)

class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] < height[i]) {
                int top = st.pop();
                if (st.isEmpty())
                    break;
                int dist = i - st.peek() - 1;
                ans += dist * (Math.min(height[i], height[st.peek()]) - height[top]);
            }
            st.push(i);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)