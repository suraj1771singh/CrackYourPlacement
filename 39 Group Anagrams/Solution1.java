import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean seen[] = new boolean[n];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seen[i])
                continue;
            seen[i] = true;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            // create freq table
            int cnt[] = new int[26];
            for (char c : strs[i].toCharArray())
                cnt[c - 'a']++;

            for (int j = i + 1; j < n; j++) {
                int[] ncnt = Arrays.copyOf(cnt, 26);
                for (char c : strs[j].toCharArray())
                    ncnt[c - 'a']--;

                // compare freq cnt;
                boolean isSame = true;
                for (int k = 0; k < 26; k++)
                    if (ncnt[k] != 0) {
                        isSame = false;
                        break;
                    }
                if (isSame) {
                    seen[j] = true;
                    temp.add(strs[j]);
                }
            }
            res.add(temp);

        }
        return res;
    }
}