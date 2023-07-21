class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer dp[] = new Integer[n];
        return f(0, s, dp);
    }

    int f(int ind, String s, Integer dp[]) {
        if (ind >= s.length())
            return 1;
        if (dp[ind] != null)
            return dp[ind];
        StringBuilder str = new StringBuilder();
        int res = 0;
        for (int i = ind; i < s.length(); i++) {
            str.append(s.charAt(i));
            int num = Integer.parseInt(str.toString());
            if (num == 0 || num > 26)
                break;
            res += f(i + 1, s, dp);
        }
        return dp[ind] = res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)