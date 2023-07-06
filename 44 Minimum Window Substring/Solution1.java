import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int n = s.length(), m = t.length();

        // Intialize HashMap
        for (char c : t.toCharArray())
            map[c]++;

        int i = 0, j = 0, cnt = m, start = 0, d = (int) 1e9;

        while (i < n) {
            if (map[s.charAt(i++)]-- > 0)
                cnt--;
            while (cnt == 0) {
                if (i - j < d) {
                    d = i - j;
                    start = j;
                }
                if (map[s.charAt(j++)]++ == 0)
                    cnt++;
            }
        }
        return d == (int) 1e9 ? "" : s.substring(start, start + d);
    }
}
// Time complexity : O(n)