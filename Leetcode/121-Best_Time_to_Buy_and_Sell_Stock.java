class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int mini = prices[0];

        for(int i = 1; i<prices.length; i++){
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}

//for day i, we need to find the minimum of previos days, because max profit = highest price - lowest price
//here the day matters, so a stock cannot be sold today and purchased later
//this is an example of DP, cause we saving the min in memory.
//we are updating min after viewing each price and simultaneously updating maxProfit