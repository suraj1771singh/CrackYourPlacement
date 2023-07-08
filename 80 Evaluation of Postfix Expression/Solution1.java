import java.util.Stack;

class Solution {

    public static int evaluatePostFix(String S) {
        Stack<Integer> st = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '*') {
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            } else if (c == '+') {
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            } else if (c == '-') {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (c == '/') {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(c - '0');
            }
        }
        return st.peek();
    }
}
// Time complexity : O(n)
// Space complexity : O(n)