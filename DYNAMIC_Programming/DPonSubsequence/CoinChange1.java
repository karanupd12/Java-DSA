package DYNAMIC_Programming.DPonSubsequence;


/*

problem Statement: https://leetcode.com/problems/coin-change/
Given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money,
 return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Approach : dp[n][amount+1] state represent the minimum number of coins needed to make up the amount using the first n coins.
key note: if infinite supply/multiple times is mentioned, then we can use the same coin multiple times.(do not use i-1 in the loop for 'take')

Flow as always :
-> Recursion : Min(take, notTake), TC : O(n*amount) SC : O(n*amount) + O(n) for recursion stack
-> Memoization : Min(take, notTake) (store and return the already calculated value), TC : O(n*amount) SC : O(n*amount) + O(n) for recursion stack
-> Tabulation: Build dp[n][amount+1] table and fill it using the above Memoization logic, TC : O(n*amount) SC : O(n*amount)
-> Space Optimization(use prev curr) : TC : O(n*amount) SC : O(amount+1) (only one row is needed to store the previous state)

Tip : Integer.MAX_VALUE + 1 can cause integer overflow, so check using (int) 1e9
*/


public class CoinChange1 {
    //Most Optimal Space optimized solution
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int amnt = 0; amnt <= amount; amnt++){
            if(amnt % coins[0] == 0) prev[amnt] = amnt / coins[0];
            else prev[amnt] = (int) 1e9;
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[amount+1];
            for(int amnt = 0; amnt <= amount; amnt++){
                int notTake = 0 + prev[amnt];
                int take = (coins[i] <= amnt) ? 1 + curr[amnt - coins[i]] : Integer.MAX_VALUE;
                curr[amnt] = Math.min(take, notTake);
            }
            prev = curr;
        }

        if(prev[amount] == (int) 1e9) return -1;
        else return prev[amount];
    }
}

/*
TABULATION
Tip : Do Nothin, just look at Memoization solution and convert that to this as it is

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        //base cases - just look at memoization and convert that to this as it is
        for(int amnt = 0; amnt <= amount; amnt++){
            if(amnt % coins[0] == 0) dp[0][amnt] = amnt / coins[0];
            else dp[0][amnt] = (int) 1e9;
        }

        //build dp - same as it is from memoization
        for(int i = 1; i < n; i++){
            for(int amnt = 0; amnt <= amount; amnt++){
                int notTake = 0 + dp[i-1][amnt];
                int take = (coins[i] <= amnt) ? 1 + dp[i][amnt-coins[i]] : Integer.MAX_VALUE;
                dp[i][amnt] = Math.min(take, notTake);
            }
        }

        if(dp[n-1][amount] == (int) 1e9) return -1;
        else return dp[n-1][amount];
    }
*/

/*
MEMOIZATION
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;

        int[][] memo = new int[n][amount+1];
        for(int[] row : memo) Arrays.fill(row, -1);

        int ans = dfs(n-1, amount, coins, memo);
        return (ans == 1e9) ? -1 : ans;
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo){
        if(i == 0){
            if(amount % coins[i] == 0) return amount / coins[i];
            else return (int)1e9;
        }

        if(memo[i][amount] != -1) return memo[i][amount];

        int notTake = 0 + dfs(i-1, amount, coins, memo);
        int take = (coins[i] <= amount) ? 1 + dfs(i, amount-coins[i], coins, memo) : Integer.MAX_VALUE;

        return memo[i][amount] = Math.min(take, notTake);
    }
*/