class Solution {

    public int lcs(String s1, int i, String s2, int j, int[][] dp) {
        if (i == -1 || j == -1) {
            return 0; // when any string is over, then theres nothing common, hence return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            int x = lcs(s1, i - 1, s2, j - 1, dp);
            dp[i][j] = x + 1;
            return x + 1;
        }

        else {
            int x = lcs(s1, i - 1, s2, j, dp);
            int y = lcs(s1, i, s2, j - 1, dp);

            dp[i][j] = Math.max(x, y);
            return Math.max(x, y);
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i][j];

      for(int k =0; k<i; k++){
        for(int l = 0; l<j; l++){
            dp[k][l] = -1;
        }
      }
        i = i - 1;
        j = j - 1;
        return lcs(text1, i, text2, j, dp);
    }
}

// if same ==> i-1, j-1 + 1
// else{
// x = lcs(s1, i-1, s2, j); //
// y = lcs (s1, i, s2, j-1); //

// max(x, y);
// }