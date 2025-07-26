package DYNAMIC_Programming.PartitionDP;
import java.util.*;

/*
Problem -https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
Given an array arr[] of size n representing dimensions of matrices (i.e., Matrix A[i] has dimension arr[i-1] x arr[i]),
find the minimum number of scalar multiplications needed to multiply the chain of matrices.

Intution -
We recursively split the matrix chain at every possible point k, compute cost of multiplying left and right partitions,
and combine them with current multiplication cost. We use memoization to avoid recomputation of overlapping subproblems.
For tabulation - just reverse the memo approach

Time complexity = O(n³)
Space complexity = O(n²)
*/

public class MCM {
    private int[][] memo;

    public int matrixMultiplication(int arr[]) {
        int n = arr.length;
        memo = new int[n][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        return mcm(1, n-1, arr);
    }

    private int mcm(int i, int j, int[] arr) {
        if (i == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = arr[i - 1] * arr[k] * arr[j];
            int totalCost = cost + mcm(i, k, arr) + mcm(k + 1, j, arr);
            minCost = Math.min(minCost, totalCost);
        }

        return memo[i][j] = minCost;
    }
}

/*
TABULATION
   int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        //base case
        for(int i= 0; i < n; i++){
            dp[i][i] = 0;
        }

        //opposite of recursion(with same recurrence relation)
        for(int i = n-1; i >= 1; i--){
            for(int j = i+1; j < n; j++){
                int minCost = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int cost = arr[i-1] * arr[k] * arr[j];
                    int totalCost = cost + dp[i][k] + dp[k+1][j];
                    minCost = Math.min(minCost, totalCost);
                }
                dp[i][j] = minCost;
            }
        }

        return dp[1][n-1];
    }
*/