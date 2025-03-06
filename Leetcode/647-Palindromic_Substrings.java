class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            int i = 0;
            int j = gap;

            while (j < n) {

                // same letters (reflexive)
                if (gap == 0) {
                    dp[i][j] = true;
                    count++;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }
}