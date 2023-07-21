class Solution {
    public int climbStairs(int n) {
        Integer dp[] = new Integer[n+1];
        return f(n,dp);
    }
    int f(int n, Integer dp[]){
        if(n<=0) return n==0 ? 1 : 0;
        if(dp[n]!=null) return dp[n];
        return dp[n] = f(n-1,dp) + f(n-2,dp);
    }
}
//Time complexity : O(n)