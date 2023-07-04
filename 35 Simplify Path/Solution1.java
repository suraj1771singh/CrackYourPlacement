import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String arr[] = path.split("/");

        for (String s : arr) {
            if (s.isEmpty() || s.equals("."))
                continue;

            else if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else
                st.push(s);
        }
        if (st.isEmpty())
            return "/";
        StringBuilder str = new StringBuilder();
        for (String s : st)
            str.append("/" + s);
        return str.toString();
    }
}
// Time complexity : O(n)