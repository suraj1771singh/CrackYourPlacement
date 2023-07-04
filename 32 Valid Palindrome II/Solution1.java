class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, h = s.length();
        while (l < h) {
            if (s.charAt(l) == s.charAt(h)) {
                l++;
                h--;
            } else
                return isPalin(l + 1, h, s) || isPalin(l, h - 1, s);
        }
        return true;
    }

    boolean isPalin(int l, int h, String s) {
        while (l < h) {
            if (s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}