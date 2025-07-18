package DYNAMIC_Programming.DPonStrings;

import java.util.Arrays;

/*

Problem Statement: https://leetcode.com/problems/longest-common-subsequence/
The Longest Common Subsequence (LCS) problem is a classic dynamic programming problem that involves finding the longest subsequence
present in two sequences. A subsequence is a sequence that can be derived from another sequence by deleting some elements
without changing the order of the remaining elements.

Approach: The problem can be solved using dynamic programming by building a 2D table where dp[i][j] represents the length of the LCS
each state dp[i][j] is derived from the previous states based on whether the characters match or not, it represents the
length of the LCS of the first i characters of s1 and the first j characters of s2.

So we get our final answer in dp[m][n] where m and n are the lengths of the two strings.

*/

public class LCS {

    //Memoization - top down (recursion + memo[][])
    public static int lcs1(String s1, String s2, int m, int n, int[][] memo) {
        if(m == 0|| n == 0) return 0;                 // Base case: If either string is empty, LCS is 0

        if(memo[m][n] != -1) return memo[m][n];       // If already computed, return stored value

        if (s1.charAt(m - 1) == s2.charAt(n - 1))     // Matching case, increase lcs
            memo[m][n] = 1 + lcs1(s1, s2, m-1, n-1, memo);

        else                                          // Non-matching case try both possibility
            memo[m][n] = Math.max(lcs1(s1, s2, m-1, n, memo), lcs1(s1, s2, m, n-1, memo));

        return memo[m][n];
    }

    //tabulation - bottom up(iterative + dp[][])
    public static int lcs2(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))      // matched
                    dp[i][j] = 1 + dp[i-1][j-1];
                else                                  // not matched
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

    public static int lcs3(String s1, String s2, int m, int n) {
        int[] prev = new int[n+1];

        for(int i = 1; i <= m; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))      // matched
                    curr[j] = 1 + prev[j-1];
                else                                  // not matched
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr; // set prev to curr for next iteration
        }

        return prev[n];
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        String s2 = "AXBYCZZDC";
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        System.out.println(lcs1(s1, s2, m, n, memo));

        System.out.println(lcs2(s1, s2, m, n));
    }
}
