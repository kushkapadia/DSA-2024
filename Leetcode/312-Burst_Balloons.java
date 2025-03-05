class Solution {

    public int maxCoinsDp(int[] arr, int s, int e, int[][] dp) {

        if (s + 1 >= e) {
            return 0; // no pints possible, because no baloons to burst
        } 
        
        if(dp[s][e] != -1){
            return dp[s][e];
        }



        // s and e both exclusive
        
        int ans = Integer.MIN_VALUE;
        for (int i = s + 1; i < e; i++) {
            // ith index will burst at last.

            int leftPart = maxCoinsDp(arr, s, i, dp);
            int rightPart = maxCoinsDp(arr, i, e, dp);

            int myAns = leftPart + rightPart + arr[s] * arr[i] * arr[e]; // out of bound condition is
                                                                                    // handled, by the 2 the extra
                                                                                    // padding that we added.
          ans=   Math.max(myAns, ans);

        }
        dp[s][e] = ans;
        return ans;
    }

    public int maxCoins(int[] nums) {

        // recursion approach

        // apppend 1 to the start and end of the array, for base case
        int[] arr = new int[nums.length + 2];

        // arr[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     arr[i] = nums[i];
        // }


        arr[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            arr[i] = nums[i - 1];  // Shift elements by 1 position
        }
        arr[nums.length+ 1] = 1;
        // arr[nums.length] = 1;

        int[][] dp = new int[nums.length+2][nums.length+2];

        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                 dp[i][j] = -1;
            }
        }
        // arr, start, end, dp
        return maxCoinsDp(arr, 0, nums.length+1 , dp);
    }
}