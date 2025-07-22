package DYNAMIC_Programming.DPonStocks;

/*
Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Problem Statement: same profit maximize karna hai, but ab multiple transactions allowed hain, but next buy se pehle first sell karna padega.

Approach : Again we can greedily find the maximum profit by iterating through the prices array.
           - If the price on the next day is higher than the current day, we can consider it as a profit opportunity.
           - We can keep adding these profits to get the total maximum profit.
- This is equivalent to summing up all the positive differences between consecutive days.
DP is not needed because there is no limit on trade or any penalty
*/

public class BuySell2 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 7
    }
}





//this is dp but just for understanding, not needed in this problem
/*  MEMOIZATION
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for(int[] arr : memo) Arrays.fill(arr, -1);
        return dfs(0, 1, prices, memo);
    }

    private int dfs(int i, int bought, int[] prices, int[][] memo){
        if(i == prices.length) return 0;

        if(memo[i][bought] != -1) return memo[i][bought];
        int profit = 0;

        if(bought == 1){     //if we have already bought a stock, we can either
            int sell = -prices[i] + dfs(i+1, 0, prices, memo); //sell, add profit and set bought to false
            int notSell = 0 + dfs(i+1, 1, prices, memo);  //move for selling in future
            profit = Math.max(sell, notSell);
        }
        else{        //not bought before, so we can either buy on not buy
            int buy = prices[i] + dfs(i+1, 1, prices, memo);
            int notBuy = 0 + dfs(i+1, 0, prices, memo);
            profit = Math.max(buy, notBuy);
        }

        return memo[i][bought] = profit;
    } */

/*  TABULATION
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0]; //bought
        dp[0][1] = 0;          //not buy

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]); //hod or buy today
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]); //do nothin or sell today
        }

        return dp[n-1][1];  // max profit ending with no stock in hand
    } */
