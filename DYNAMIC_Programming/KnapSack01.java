package DYNAMIC_Programming;

import java.util.Arrays;

public class KnapSack01 {

    //Memoization - top down
    private static int knapsack1(int w, int[] weights, int[] values, int n, int[][] dp) {
        if(n == 0 || w == 0) return 0;      //base case
        if(dp[n][w] != -1) return dp[n][w]; //return stored result

        if(weights[n-1] > w)
            return dp[n][w] = knapsack1(w, weights, values, n-1, dp);

        int include = values[n-1] + knapsack1(w - weights[n-1], weights,  values, n-1, dp);
        int exclude = knapsack1(w, weights, values, n-1, dp);

        return dp[n][w] = Math.max(include, exclude);
    }

    //Tabulation - bottom up
    private static int knapsack2(int W, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i - 1] <= j) {   //we can fit
                    int include = values[i-1] + dp[i-1][j-weights[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else {     //can't fit, so copy above one
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }


    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {10, 40, 50, 70};
        int W = 8;
        int n = weights.length;
        int[][] dp = new int[n+1][W+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(knapsack1(W, weights, values, n, dp));
        System.out.println(knapsack2(W, weights, values, n));
    }

}


/* BRUTE FORCE :
private static int knapsack(int w, int[] weights, int[] values, int n) {
        if(w == 0 || n == 0) return 0;

        if(weights[n-1] > w)
            return knapsack(w, weights, values, n-1);

        int include = values[n-1] + knapsack(w - weights[n-1], weights,  values, n-1);
        int exclude = knapsack(w, weights, values, n-1);

        return Math.max(include, exclude);
    }*/