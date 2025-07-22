package DYNAMIC_Programming.DPonStocks;

/*
Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

Approach - same just buy sell as usual but this time , when you sell, increment day by + 2, because next day after selling
is a cooldown day when we can not buy anything, so we can buy only day after tomorrow

*/

public class BuySellCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];  //dp[day][canBuy];

        for(int i = n-1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                if(canBuy == 1){
                    dp[i][canBuy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    dp[i][canBuy] = Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }

    //space optimized
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] after = new int[2];
        int[] afterTwo = new int[2];

        for(int i = n-1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                if(canBuy == 1){
                    curr[canBuy] = Math.max(-prices[i] + after[0], after[1]);
                }else{
                    curr[canBuy] = Math.max(prices[i] + afterTwo[1], after[0]);
                }
            }
            afterTwo = after.clone();
            after = curr.clone();
        }

        return curr[1];
    }
}
