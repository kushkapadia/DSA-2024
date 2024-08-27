class Solution {

    public int numOfPath(int i, int j, int[][] dp){
        if(i == 0|| j == 0){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int x = numOfPath(i-1, j, dp);
        int y = numOfPath(i, j-1, dp);

        dp[i][j] = x+y;
        return x+y;
    }

    public int uniquePaths(int m, int n) {
        int [][] dp= new int[n][m];
      for(int i = 0; i<n; i++){
        Arrays.fill(dp[i], -1);
      }
   return numOfPath(n-1, m-1, dp);
    }
}