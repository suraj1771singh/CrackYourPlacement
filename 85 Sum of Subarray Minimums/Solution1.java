import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int MOD = (int) 1e9 + 7;
        int next[] = new int[n];
        int prev[] = new int[n];
        Arrays.fill(next, n);
        Arrays.fill(prev, -1);

        // smaller to right side
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                next[st.pop()] = i;
            st.push(i);
        }
        st.clear();
        // smaller to left side
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                prev[st.pop()] = i;
            st.push(i);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int l = i - prev[i];
            int r = next[i] - i;
            int temp = (int) ((arr[i] * 1L * l * r) % MOD);
            sum = (sum + temp) % MOD;
        }
        return sum;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)