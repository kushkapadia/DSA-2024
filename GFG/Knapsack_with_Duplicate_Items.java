// User function Template for Java

class Solution {
    
    static int maxvalue(int[] val, int[] wt, int capacity, int i, int[][] dp){
        
        if(i<0 || capacity ==-1){
            return 0;
        }
        
        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }
        
        //exclude
        int x = maxvalue(val, wt, capacity, i-1, dp);
        
        int y = 0;
        if(capacity>=wt[i]){
        y = maxvalue(val, wt, capacity-wt[i], i, dp) + val[i];
        }
        
        dp[i][capacity] =  Math.max(x,y);
        
       return Math.max(x,y);
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[][] dp = new int[val.length][capacity +1];
        
        for(int i = 0; i<val.length; i++){
            for(int j = 0; j<=capacity; j++){
                dp[i][j] = -1;
            }
        }
        
        int i = val.length -1;
        return maxvalue(val, wt, capacity, i, dp);
    }
}