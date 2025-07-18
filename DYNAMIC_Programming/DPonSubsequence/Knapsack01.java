package DYNAMIC_Programming.DPonSubsequence;

/*
Problem Statement: https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
The 0/1 Knapsack Problem is a classic optimization problem where you have a set of items, each with a weight and a value, and you want to determine the maximum value
you can carry in a knapsack of a given capacity. Each item can either be included in the knapsack or excluded (hence "0/1").

Approach :- Recursion -> Memoization -> Tabulation -> Space Optimization
Maximize the value of items in the knapsack without exceeding its capacity by taking capacity as target.
*/

class Knapsack01 {
    //BEST SPACE OPTIMIZED APPROACH
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] prev = new int[W+1];
        //Base case
        for(int w = 0; w <= W; w++) {
            if (wt[0] <= w) prev[w] = val[0];
            else prev[w] = 0;
        }
        //build dp array
        for(int i = 1; i < n; i++){
            int[] curr = new int[W+1];
            for(int w = 0; w <= W; w++){
                int notPick = 0 + prev[w];
                int pick = (wt[i] <= w) ? val[i] + prev[w - wt[i]] : 0;
                curr[w] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[W];
    }
}

/* TABULATION
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;

        int[][] dp = new int[n][W+1];

        for(int w = 0; w <= W; w++){
            if(wt[0] <= w) dp[0][w] = val[0];
            else dp[0][w] = 0;
        }


        for(int i = 1; i < n; i++){
            for(int w = 0; w <= W; w++){
                int notPick = 0 + dp[i-1][w];
                int pick = (wt[i] <= w) ? val[i] + dp[i-1][w - wt[i]] : 0;
                dp[i][w] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][W];
    }

*/

/*  MEMOIZATTION
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;

        int[][] memo = new int[n][W+1];
        for(int[] arr : memo) Arrays.fill(arr, -1);
        return dfs(n-1, W, val, wt, memo);
    }

    static int dfs(int i, int capacity, int[] val, int[] wt, int[][] memo){
        if(i == 0){
            if(wt[i] <= capacity) return val[i];
            else return 0;
        }

        if(memo[i][capacity] != -1) return memo[i][capacity];

        int notPick = 0 + dfs(i-1, capacity, val, wt, memo);
        int pick = 0;
        if(wt[i] <= capacity){
            pick = val[i] + dfs(i-1, capacity - wt[i], val, wt, memo);
        }

        return memo[i][capacity] = Math.max(pick, notPick);
    }

*/


