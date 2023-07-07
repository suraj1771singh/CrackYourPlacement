class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int nres = res * 10 + x % 10;
            if ((nres - x % 10) / 10 != res)
                return 0;
            res = nres;
            x /= 10;
        }
        return res;
    }
}
