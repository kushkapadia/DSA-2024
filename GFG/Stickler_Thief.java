class Solution {
    // Function to find the maximum money the thief can get.
    
    public int maxAmt(int[] arr, int i, int[] dp){
        
        if(i<0){
            return 0; //sub sequence can aslo be an empty array, if its empty the sum will be 0, hence return 0
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        //exclude
        int x = maxAmt(arr, i-1, dp);
        
        // include. i-2 because, consecutive are not allowed
        int y = maxAmt(arr, i-2, dp) + arr[i];
        dp[i] = Math.max(x, y);
        return Math.max(x, y);
    }
    
    public int findMaxSum(int arr[]) {
        // Your code here
        
        int dp[] = new int[arr.length];
        int i = arr.length -1;
        Arrays.fill(dp, -1);
        return maxAmt(arr, i, dp);
        
    }
}

//see this question as maximum sunbsequence sum

//This is a dp maximization problem.
//approach
/*

Input: arr[] = [6, 5, 5, 7, 4]
Output: 15

n = 5
i = 4

arr(0, 4)
--> exclude.     include
arr(o, 3)       arr(0, 2) + arr[4] //if i want to include index 4 then index 3 can never be used, therefore, 0,2

exclude         include
arr(0, 2)       arr(0, 1) + arr[3];
exclude
arr(0, 1)      arr(0,0) + arr[2] 

*/