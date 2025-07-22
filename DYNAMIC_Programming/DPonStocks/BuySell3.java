package DYNAMIC_Programming.DPonStocks;

/*
Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
Approach : this can not be solved using greedy as we have a limit on transaction, keep the track of all three changing
parameter like days(i), canbuy(1 or 0) and transactions done (2 allowed)
- if can buy -> buy(-price) or skip
-if cannoy buy -> sell(+price) or hold
Note : transaction is considered done only when we sell a stock
Start with memoization -> tabulation -> space optimization
*/

public class BuySell3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i = n - 1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){   //0 - cannot buy, i - canBuy
                for(int t = 0; t < 2; t++){    //0, 1
                    if (canBuy == 1) {
                        int buy = -prices[i] + dp[i+1][0][t];  // Option 1: Buy the stock today
                        int skip = 0 + dp[i+1][1][t];          // Option 2: Skip buying today
                        dp[i][1][t] = Math.max(buy, skip);
                    }else {
                        int sell = prices[i] + dp[i+1][1][t+1];  // Option 1: Sell the stock today
                        int hold = dp[i+1][0][t];                  // Option 2: Hold the stock (don’t sell today)
                        dp[i][0][t] = Math.max(sell, hold);
                    }
                }
            }
        }

        return dp[0][1][0];   // start at day 0, can buy, 0 transactions done
    }
}

/* SPACE OPTIMIZED
// dp[canBuy][transactionsCompleted]
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after= new int[2][3];
        int[][] curr = new int[2][3];

        for(int i = n - 1; i >= 0; i--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){   //0 - cannot buy, i - canBuy
                for(int t = 0; t < 2; t++){    //0, 1
                    if (canBuy == 1) {
                        int buy = -prices[i] + after[0][t];  // Option 1: Buy the stock today
                        int skip = 0 + after[1][t];          // Option 2: Skip buying today
                        curr[1][t] = Math.max(buy, skip);
                    }else {
                        int sell = prices[i] + after[1][t+1];  // Option 1: Sell the stock today
                        int hold = after[0][t];                  // Option 2: Hold the stock (don’t sell today)
                        curr[0][t] = Math.max(sell, hold);
                    }
                }
                after = curr;
            }
        }

        return curr[1][0];   // start at day 0, can buy, 0 transactions done
    }
*/

/*

    //MEMOIZED Solution for logic understanding
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];         // At most 2 transactions (0, 1, 2)
        for (int[][] state : dp) {
            for (int[] row : state) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, 1, 0, prices); // Start at day 0, we can buy, 0 transactions done
    }

    private int dfs(int i, int canBuy, int transac, int[] prices) {
        if (i == prices.length || transac == 2) return 0;

        if (dp[i][canBuy][transac] != -1)
            return dp[i][canBuy][transac];

        int profit = 0;

        if (canBuy == 1) {
            int buy = -prices[i] + dfs(i + 1, 0, transac, prices);  // Option 1: Buy the stock today
            int skip = 0 + dfs(i + 1, 1, transac, prices);          // Option 2: Skip buying today
            profit = Math.max(buy, skip);

        } else {
            int sell = prices[i] + dfs(i + 1, 1, transac + 1, prices);  // Option 1: Sell the stock today
            int hold = dfs(i + 1, 0, transac, prices);                  // Option 2: Hold the stock (don’t sell today)
            profit = Math.max(sell, hold);
        }

        return dp[i][canBuy][transac] = profit;
    }
 */

