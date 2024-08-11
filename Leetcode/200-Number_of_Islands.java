class Solution {
  private boolean isInBounds(int newr, int newc, int n, int m){
        return (newc >= 0 && newc < m && newr >= 0 && newr < n);
    }

    public void dfs(char[][] grid, int i, int j, int n, int m, boolean[][] vis){
        int[][] dir ={
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

// for(k = 0; k<4; k++){
//     int nr = i + dir[]
//         if(vis[i][j] != true){
            
//         }
// }
 for (int k = 0; k < 4; k++) {
            int nr = i + dir[k][0];
            int nc = j + dir[k][1];
            if (isInBounds(nr, nc, n, m)==true && !vis[nr][nc] && grid[nr][nc] == '1') {
                vis[nr][nc] = true;
                dfs(grid, nr, nc, n, m,  vis);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
       
    boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.println("Here");
                if( !vis[i][j]  && grid[i][j] == '1'  ){
                System.out.println("Here Also");
                    
                    vis[i][j] = true;
                    dfs(grid, i, j, n, m, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}

