class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n; i++) {
            int k = i;
            int j = 0;
            while (k < n && j < m && haystack.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
            }
            if (j >= m)
                return i;
        }
        return -1;
    }
}