class Solution {
    // public int fib(int n) {

// if(n<=1){
//     return n;
// }

// int sum = 0;
// int a = 0;
// int b = 1;
//         for(int i=1; i<n; i++){
//                 sum = a +b;
//                 a = b;
//                 b = sum;
//         }
//         return sum;
//   ??  }
// }

    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return fibHelper(dp ,n);
    }

    public int fibHelper(int[] dp, int n){
if(n == 1 || n==0){
    return n;
}

if(dp[n] != -1){
    return dp[n];
}

        int a=  fibHelper(dp, n-1);
        int b = fibHelper(dp, n-2);

        dp[n] = a+b;
        return a+b;
    }
        }

    