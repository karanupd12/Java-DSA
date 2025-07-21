package DYNAMIC_Programming.DPonStrings;

/*
Problem : https://leetcode.com/problems/longest-palindromic-subsequence/
Problem Statement: Given a string s, find the length of the longest palindromic subsequence in s.

Approach : Tabulation - LCS(s, rev(s)) - because a palindrome is a string that reads the same forwards and backwards.(no rocket science here)
*/
public class LPS {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        LPS lps = new LPS();
        String s = "abcbbaqrb";
        System.out.println("Length of Longest Palindromic Subsequence: " + lps.longestPalindromeSubseq(s)); // Output: 5 , "abbba"
    }
}

/*  SPACE OPTIMIZED TABULATION
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int[] prev= new int[n+1];
        for(int i = 1; i <= n; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
 */
