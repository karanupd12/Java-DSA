package DYNAMIC_Programming.DPonSubsequence;

/*
Problem Statement: https://leetcode.com/problems/coin-change-2/
-> Given an amount and an array of coin denominations(multiple supplies), find the number of ways to make up that amount using the coins.

->Approach: dp[n][amount+1] state represents the number of ways to make up the amount using the first n coins.
  Very simple logic : some of all possible (take + notTake) combinations.

-> Flow as always: Recursion -> Memoization -> Tabulation -> Space Optimization
Note : 1. If infinite supply/multiple times is mentioned, then we can use the same coin multiple times (do not use i-1 in the loop for 'take').
       2. Also for i = 0, we can only take the first coin if it divides the amount evenly.
*/

public class CoinChange2 {
    //best space optimized solution
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int amnt = 0; amnt <= amount; amnt++){
            if(amnt % coins[0] == 0) prev[amnt] = 1;
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[amount+1];
            for(int amnt = 0; amnt <= amount; amnt++){
                int notTake = prev[amnt];
                int take = (coins[i] <= amnt) ? curr[amnt-coins[i]] : 0;
                curr[amnt] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }
}


/*   TABULATION - do not waste time - analyze and copy from memo solution
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //base case - simpley look at memo solution
        for(int amnt = 0; amnt <= amount; amnt++){
            if(amnt % coins[0] == 0) dp[0][amnt] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int amnt = 0; amnt <= amount; amnt++){
                int notTake = dp[i-1][amnt];
                int take = (coins[i] <= amnt) ? dp[i][amnt-coins[i]] : 0;
                dp[i][amnt] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }
 */

/*  MEMOIZATION
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n][amount+1];
        for(int[] arr : memo) Arrays.fill(arr, -1);
        return dfs(n-1, amount, coins, memo);
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo){
        if(i == 0){
            if(amount == 0 || amount % coins[i] == 0) return 1;
            else return 0;
        }
        if(memo[i][amount] != -1) return memo[i][amount];
        int notTake = dfs(i-1, amount, coins, memo);
        int take = (coins[i] <= amount) ? dfs(i, amount - coins[i], coins, memo) : 0;
        return memo[i][amount] = take + notTake;
    }
 */