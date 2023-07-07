//Set bit must be only one
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
            if (cnt > 1)
                return false;
        }
        return true;
    }
}