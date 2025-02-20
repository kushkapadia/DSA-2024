class Solution {
    public int lengthOfLIS(int[] nums) {

        // brute force. tc: O(N^2) sc: O(N)
        int[] dp = new int[nums.length];

        // for (int i = 0; i < nums.length; i++) {
        // dp[i] = 1; // filling it with 1 because if no sequence is found, the
        // individual is also
        // // considers as subsequnce, hence minimum answer length = 1;
        // }
        // int ans = 1;
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i - 1; j >= 0; j--) {
        // // traverse j backwards
        // if (nums[i] > nums[j]) {
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // }
        // }
        // ans = Math.max(ans, dp[i]); // maximum out of complete dp array
        // }

        // // for (int i = 0; i < nums.length; i++) {
        // // System.out.print(dp[i] + " ");
        // // }
        // return ans;

        // for (int i = 0; i < nums.length; i++) {
        //     dp[i] = 0;
        // }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = 0;
            int high = ans;

            while (low < high) {
                int m = low + ( high-low) / 2;

                if (dp[m] < nums[i]) {
                    low = m +1;
                } else {
                    high = m;
                }
            }

            dp[low] = nums[i]; //when low == high
            if (low == ans) {
                ans++;
            }
        }

    // for (int i = 0; i < nums.length; i++) {
    //     System.out.print(dp[i] + " ");
    //     }
        
        return ans;
    }
}

// lass Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         int ans = 0;
//         for(int i = 0; i<n; i++){
//             int lo = 0, hi = ans;
//              while(lo < hi){
//                  int m = lo + (hi-lo)/2;
//                  if(dp[m] < nums[i]){
//                      lo = m+1;
//                  } else {
//                      hi = m;
//                  }
//              }
//             dp[lo] = nums[i];
//             if(lo == ans) ans++;
//         }
//         return ans;
//     }
// }

