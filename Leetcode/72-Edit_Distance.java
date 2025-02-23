class Solution {

    public int min(String w1, int i, String w2, int j, int[][] dp) {

        // when both are empty, then 0 operations
        if (i == -1 && j == -1) {
            // hence return 0
            return 0;
        }
        if (i == -1 && j != -1) {
            // if w2 is non empty, then we have no option but add remaining characters in w1
            return j + 1;
        }
        if (i != -1 && j == -1) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (w1.charAt(i) == w2.charAt(j)) {
            int x = min(w1, i - 1, w2, j - 1, dp);
            dp[i][j] = x;
            return x;
        } else {
            int x = min(w1, i, w2, j - 1, dp); // add in w1
            int y = min(w1, i - 1, w2, j - 1, dp); // replace in w1
            int z = min(w1, i - 1, w2, j, dp); // delete in w1
            dp[i][j] = Math.min(x, Math.min(z, y)) +1;
            return Math.min(x, Math.min(z, y)) +1; //smallest of previos + the 1 current operation taht we jsut performed
        }
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int i = n - 1;
        int j = m - 1;

        return min(word1, i, word2, j, dp); 
    }
}
