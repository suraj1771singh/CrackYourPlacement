class Solution {
    public boolean isHappy(int n) {
        int len = (int) Math.floor(Math.log10(n) + 1);
        if (len == 1)
            return n == 1 || n == 7;
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return isHappy(sum);
    }
}