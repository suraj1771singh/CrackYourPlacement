import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty())
                st.add(new int[] { c, 1 });
            else {
                if (st.peek()[0] == c) {
                    if (st.peek()[1] == k - 1) {
                        while (!st.isEmpty() && st.peek()[0] == c)
                            st.pop();
                    } else {
                        st.add(new int[] { c, st.peek()[1] + 1 });
                    }
                } else {
                    st.add(new int[] { c, 1 });
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i[] : st) {
            str.append((char) i[0]);
        }
        return str.toString();
    }
}
// Time complexity : O(n)
// Spac complexity : O(n)