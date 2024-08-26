class Solution {
// same as fib

    public int climbHelper(int[] dp, int n){

        if(n ==1 || n ==2){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int a = climbHelper(dp, n-1);
        int b = climbHelper(dp, n-2);
        dp[n] = a+b;
        return a + b;

    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbHelper(dp, n);
    }
}