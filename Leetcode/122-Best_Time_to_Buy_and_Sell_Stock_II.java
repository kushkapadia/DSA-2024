class Solution {

    public int max(int[] prices, int i, int canBuy, int[][] dp) {

        // base case
        // if days are over then return 0;
        if (i == prices.length) {
            
            return 0;
        }

        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

int profit = 0;
        if (canBuy == 1) {
            int buy = max(prices, i + 1, 0, dp) - prices[i]; // either Buy
            int skip = max(prices, i + 1, 1, dp) - 0; // or dont buy. if i dont buy, i can buy later, hence passed true
            dp[i][canBuy] = Math.max(buy, skip);
            profit =  Math.max(buy, skip); // as we need the max profiyt

        } else {
            int sell = max(prices, i + 1, 1, dp) + prices[i]; // sell
            int skip = max(prices, i + 1, 0, dp) + 0; // dont sell
            dp[i][canBuy] = Math.max(sell, skip);
            profit =  Math.max(sell, skip);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {

        int[][] dp= new int[prices.length][2]; //2 for Buy --> 0, 1

        for(int i =0; i< prices.length; i++){
            for(int j = 0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        int canBuy = 1;
        int i = 0;
        return max(prices, i, canBuy, dp);
    }
}