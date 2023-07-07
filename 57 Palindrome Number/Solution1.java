class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int num = x;
        // revers the number
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return num == y;
    }
}