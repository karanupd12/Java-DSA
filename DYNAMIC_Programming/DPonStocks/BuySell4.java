package DYNAMIC_Programming.DPonStocks;

/*

Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Same as buy sell 3, , but we allowed k transactions this time
*/

public class BuySell4 {
    //Space optimized approach
    //dp[days][canBuy][tranasactionLeft]
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] curr  = new int[2][k+1];
        int[][] after = new int[2][k+1];

        for(int i = n-1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int t = k-1; t >= 0; t--){
                    if(canBuy == 1){
                        curr[canBuy][t] = Math.max(-prices[i] + after[0][t], after[1][t]);
                    }else{
                        curr[canBuy][t] = Math.max(prices[i] + after[1][t+1], after[0][t]);
                    }
                }
                after = curr.clone();
            }
        }
        return curr[1][0];
    }
}

/* TABULATION
//dp[days][canBuy][tranasactionLeft]
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i = n-1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int t = k-1; t >= 0; t--){
                    if(canBuy == 1){
                        dp[i][canBuy][t] = Math.max(-prices[i] + dp[i+1][0][t], dp[i+1][1][t]);
                    }else{
                        dp[i][canBuy][t] = Math.max(prices[i] + dp[i+1][1][t+1], dp[i+1][0][t]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
 */
/*
int[][][] dp;  //dp[days][canBuy][tranasactionLeft]
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][k+1];
        for(int[][] mat : dp){
            for(int[] row : mat) Arrays.fill(row, -1);
        }
        return dfs(0, 1, k, prices);  //day = 0, canBuy = 1(yes), transactionLeft = k
    }

    private int dfs(int i, int canBuy, int t, int[] prices){
        if(i == prices.length || t == 0) return 0;   //when days are over or 0 transactions are left

        if(dp[i][canBuy][t] != -1) return dp[i][canBuy][t];

        int profit = 0;
        if(canBuy == 1){
            int buy = -prices[i] + dfs(i+1, 0, t, prices);
            int skip = 0 + dfs(i+1, 1, t, prices);
            profit = Math.max(buy, skip);
        }else{
            int sell = prices[i] + dfs(i+1, 1, t-1, prices);
            int hold = 0 + dfs(i+1, 0, t, prices);
            profit = Math.max(sell, hold);
        }

        return dp[i][canBuy][t] = profit;
    } */