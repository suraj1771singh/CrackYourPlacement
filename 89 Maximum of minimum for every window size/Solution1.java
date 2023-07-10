import java.util.*;

class Solution {
    // Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) {
        // find the impact region for all indices;
        int right[] = new int[n];
        int left[] = new int[n];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                right[st.pop()] = i;
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                left[st.pop()] = i;
            st.push(i);
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            res[width - 1] = Math.max(res[width - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }
        return res;
    }
}