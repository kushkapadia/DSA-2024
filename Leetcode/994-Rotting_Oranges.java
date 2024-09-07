class Solution {

    class Pair{
        int row;
        int col;
        int time;

        Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList();

int count = 0;
 for(int i = 0; i< n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 0){
                   count++;
                }   
                
            }
        }
if(count == m*n){
    return 0;
}
        for(int i = 0; i< n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 2){
                    Pair p = new Pair(i, j, 0);
                    q.add(p);
                }   
                
            }
        }



        int ans = -1;
     
        while(q.size()>0){
            Pair rem = q.remove();
            int cRow = rem.row;
            int cCol = rem.col;
            int time = rem.time;

            ans = time;
            //top
            if(cRow-1>=0 && grid[cRow-1][cCol] == 1){
                q.add(new Pair(cRow-1, cCol, time+1));
                grid[cRow-1][cCol] = 2;
            }
            //left
             if(cCol-1 >=0 && grid[cRow][cCol-1] == 1){
                q.add(new Pair(cRow, cCol-1, time+1));
                grid[cRow][cCol-1] = 2;
            }
            //down
             if(cRow+1 <n && grid[cRow+1][cCol] == 1){
                q.add(new Pair(cRow+1, cCol, time+1));
                grid[cRow+1][cCol] = 2;
            }

            if(cCol+1 <m && grid[cRow][cCol+1] == 1){
                q.add(new Pair(cRow, cCol+1, time+1));
                grid[cRow][cCol+1] = 2;
            }
        }

     for(int i = 0; i< n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 1){
                   return -1;
                }              
            }
        }

        return ans;
    }
}