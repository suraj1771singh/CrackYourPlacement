import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int cnt[] = new int[26];
        int n = s.length();
        for (char c : s.toCharArray())
            cnt[c - 'a']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> cnt[b] - cnt[a]);
        for (int i = 0; i < 26; i++)
            if (cnt[i] != 0)
                pq.add(i);

        char t[] = new char[n];
        int ind = 0;
        while (!pq.isEmpty()) {

            int it = pq.poll();
            char c = (char) (it + 'a');
            int k = cnt[it];
            if (k > (n + 1) / 2)
                return "";
            while (k-- > 0) {
                t[ind] = c;
                ind += 2;
                if (ind >= n)
                    ind = 1;
            }
        }
        return new String(t);

    }
}
// Time complexity : O(nlogn)