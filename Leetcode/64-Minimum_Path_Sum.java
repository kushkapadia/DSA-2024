class Solution {

    public int minPath(int [][] grid, int i, int j, int[][] dp){

        if(i<0 || j<0){
            return Integer.MAX_VALUE; //because we have to take minimum. This vlue will never be the a
        }
        if(i ==0 && j==0){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int x = minPath(grid, i-1, j, dp);
        int y = minPath(grid, i, j-1, dp);
        dp[i][j] = Math.min(x, y) + grid[i][j];
        return Math.min(x, y) + grid[i][j];

    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        return minPath(grid, n-1, m-1, dp );
    }
}