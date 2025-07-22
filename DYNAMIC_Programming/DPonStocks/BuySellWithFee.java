package DYNAMIC_Programming.DPonStocks;

/*
Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
Same buy sell problem but this time we have no limit and cooldown or anything just a fixed fee associated with each transaction

Approach 1:  DP : Just do usual buy and sell but when you sell, also subtract fee
Approach 2: Greedy : Because there is no limit or contraint, justa fixed fee, we can greedily find at each step if buy or skip gives more profit
and then update hold if as max of hold or sell
*/
public class BuySellWithFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = n-1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                if(canBuy == 1){
                    dp[i][canBuy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    dp[i][canBuy] = Math.max(prices[i] - fee + dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
     //Greedy
     public int maxProfitGreedy(int[] prices, int fee) {
         int cash = 0;   //if not buy
         int hold = -prices[0];   //bought and hold
         for(int i = 1; i < prices.length; i++){
             cash = Math.max(cash, hold + prices[i] - fee); //max of skip or buy
             hold = Math.max(hold, cash - prices[i]);    //max of hold or sell
         }
         return cash;
     }
}
