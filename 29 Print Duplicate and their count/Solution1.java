import java.util.*;

class Solution {
    void printDuplicate(String s, int n) {
        int cnt[] = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 1)
                System.out.println((char) (i + 'a') + " " + cnt[i]);
        }
    }
}