package DYNAMIC_Programming.DPonSubsequence;
import java.util.Arrays;

/*
Problem Statement: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
A rod of length n inches is to be cut into pieces of integer lengths. The lengths of the pieces and their prices are given in a table.
The goal is to cut the rod in such a way that the total price of the pieces is maximized.

Intution : make dp[n][n+1] to store max profit where state dp[i][j] means maxProfit for rod of length j using piece of length i+1.
Approach : Recursion -> Memoization -> Tabulation -> Space Optimization
Tip : just crack the recursion part rest all is as simple as copy paste.
Infinite suppl
*/

public class RodCutting {
    
    //MEMOIZATION - UNDERSTAND THIS ONLY (rest tabulation and space optimization is as easy as copy paste)
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] memo = new int[n][n+1];
        for(int[] row : memo) Arrays.fill(row, -1);
        return dfs(n-1, n, price, memo);
    }

    private int dfs(int i, int rodLen, int[] price, int[][] memo){
        if(i == 0){
            if(rodLen <= 0) return 0;
            else return rodLen * price[0];
        }
        if(memo[i][rodLen] != -1) return memo[i][rodLen];

        int pieceLen = i+1; // because it is a one indexed array
        int cut = (pieceLen <= rodLen) ? price[i] + dfs(i, rodLen - pieceLen, price, memo) : 0; //not decrementing i becuse of infinite supply
        int notCut = 0 + dfs(i-1, rodLen, price, memo);

        return memo[i][rodLen] = Math.max(cut, notCut);
    }
}

/*  TABULATION - MOST INTUTIVE
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];

        for(int size = 1; size <= n; size++){
            dp[0][size] = size * price[0];
        }

        for(int i = 1; i < n; i++){
            int pieceLen = i+1;
            for(int rodLen = 0; rodLen <= n; rodLen++){
                int notCut = 0 + dp[i-1][rodLen];
                int cut = (pieceLen <= rodLen) ? price[i] + dp[i][rodLen - pieceLen] : 0;
                dp[i][rodLen] = Math.max(cut, notCut);
            }
        }

        return dp[n-1][n];
    }

*/

/*
Space optimized best approach :
    public int cutRod(int[] price) {
        int rodLength = price.length;
        int[] prev = new int[rodLength+1];

        for(int size = 1; size <= rodLength; size++){
            prev[size] = size * price[0];
        }

        for(int i = 1; i < rodLength; i++){
            int[] curr = new int[rodLength+1];
            int pieceLen = i+1;
            for(int rodLen = 0; rodLen <= rodLength; rodLen++){
                int notCut = 0 + prev[rodLen];
                int cut = (pieceLen <= rodLen) ? price[i] + curr[rodLen - pieceLen] : 0;
                curr[rodLen] = Math.max(cut, notCut);
            }
            prev = curr;
        }

        return prev[rodLength];
    }



*/
