package DYNAMIC_Programming.DPonStrings;

/*

Promble : https://leetcode.com/problems/distinct-subsequences/
Problem Statement: Given two strings s and t, return the number of distinct subsequences of s which equals t.

Approach : it not lcs length problem but an all path problem as well
Try basic approach : Recursion -> Memoization -> Tabulation(1 indexed lcs form)

Intutiion : when the characters match, we have two choices:
1. Choose the character from s and move both indices (i-1, j-1).
2. Do not choose the character from s and move only the index of s (i-1, j).
When the characters do not match, we can only move the index of s (i-1, j).

*/

public class DistinctSubseq {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return 0;

        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) dp[i][0] = 1;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    int choose = dp[i-1][j-1];
                    int notChoose = dp[i-1][j];
                    dp[i][j] = choose + notChoose;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}

// better understand using memoization

/*
public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return 0;
        int[][] memo = new int[m][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        return dfs(m-1, n-1, s, t, memo);

    }

    private int dfs(int i, int j, String s, String t, int[][] memo){
        if(i < 0 || j < 0){
            if(j < 0) return 1;
            else return 0;
        }
        if(memo[i][j] != -1) return memo[i][j];

        //matched
        if(s.charAt(i) == t.charAt(j)){
            int match = dfs(i-1, j-1, s, t, memo); //choosing this i to match j (move both i and j)
            int notMatch = dfs(i-1, j, s, t, memo);    //choose some other i (only move i)
            return memo[i][j] = match + notMatch;
        }

        //not matched - only one option - move i
        return memo[i][j] = dfs(i-1, j, s, t, memo);
    }
 */
