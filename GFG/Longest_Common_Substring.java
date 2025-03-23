// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n][m];
        int maxLen = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                      
                    } else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    maxLen = Math.max(maxLen,  dp[i][j] );
                }        
            }
        }
        
        return maxLen;
    }
}

//visualize the grid and then understand. For i == 0 or j == 0 we directly put 1 if matching and 0 if not. this is because i-1 or j -1 will give us out of bound exception.
//we are mantaining the maxLen pointer to grab the longest count.