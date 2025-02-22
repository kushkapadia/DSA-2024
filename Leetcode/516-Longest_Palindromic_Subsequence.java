class Solution {

    public int lcs(String s, int i, String s2, int j, int[][] dp){

        if(i == -1 || j== -1){
            return 0;
        }

    if(dp[i][j] != -1){
        return dp[i][j];
    }

        if(s.charAt(i) == s2.charAt(j)){
            int x= lcs(s, i-1, s2, j-1, dp);
            dp[i][j] = x+1;
            return x+1;
        }  else{
            int x = lcs(s, i-1, s2, j,  dp);
            int y = lcs(s, i, s2, j-1, dp);
            dp[i][j] = Math.max(x, y);
            return Math.max(x, y);
        }
    }

    public int longestPalindromeSubseq(String s) {
        
          StringBuilder res = new StringBuilder();

        // Appending elements of s in res
        res.append(s);

        // reverse StringBuilder res
        res.reverse();
        String s2 = res.toString();
System.out.println(s2);
        int i = s.length();
        int j = s.length();
        int[][] dp = new int[i][j];

        for(int k = 0; k<i; k++){
            for(int l = 0; l<j; l++){
                dp[k][l] = -1;
            }
        }
        return lcs(s, i-1, s2, j-1, dp);
   
    }
}


/*

approach;
when the palindrome string is reversed
and then compared to the original string..
the length of  lcs of the reversed string and original string == ans
eg: bbbab
reverse: babbb
lca = bbbb == 4

eg: cbbd
rev: dbbc
lca == bb == 2
*/