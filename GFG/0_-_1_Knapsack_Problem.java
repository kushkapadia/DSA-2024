class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int maxValue(int capacity, int[] val, int[] wt, int i, int[][] dp){
        
        
        if(i==-1 || capacity == 0){
            return 0;
        }
        
        if(dp[i][capacity]!=-1){
            return dp[i][capacity];
        }
        
        //exclude
        int x = maxValue(capacity, val, wt, i-1, dp);
        
        // include
        int y = 0;
        if(capacity>=wt[i]){
        y= maxValue(capacity-wt[i], val, wt, i-1, dp) + val[i];
        }
        
        dp[i][capacity] = Math.max(x,y);
        return Math.max(x,y);
        
    }
    
    
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        
        //2d dp
        int[][] dp = new int[val.length][capacity +1 ]; //we need capacity as index,  hence we do capacity +1;
        
      // Correct way to fill a 2D array with -1
for(int i = 0; i<val.length; i++){
    for(int j = 0; j<=capacity; j++){
        dp[i][j] = -1;
    }
}
        int i = val.length -1;
        return maxValue(capacity, val, wt, i, dp);
        
    }
}

/*

Aproach
include-exclude.
Consecutive are allowed so, no need to do i-2
if included then add value to the answer and subtract the weight added from total needed
neeed to check if k>weight[i] or else it will go innegative, which will be a problem

*/