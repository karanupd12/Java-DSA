package DYNAMIC_Programming.DPonStrings;

/*
Problem : https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
Minimum Insertion Steps to Make a String Palindrome

Approach : find the length of longest palindromic subsequence (LPS) using LCS(s, rev(s)).
           - The minimum number of insertions required to make a string palindrome is equal to the difference between the length of the string and the length of its LPS.
           - So, answer = n - LPS(s).
*/

public class InsertionLPS {
    public static int minInsertions(String s) {
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();

        // Create a DP table to store lengths of longest common subsequence
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == revS.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of longest palindromic subsequence
        int lpsLength = dp[n][n];

        // Minimum insertions required to make the string a palindrome
        return n - lpsLength;
    }

    public static void main(String[] args) {
        String s = "leetcode";  //lps = ece (length = 3) so, min insertions = 8 - 3 = 5
        System.out.println("Minimum insertions to make the string a palindrome: " + minInsertions(s)); // Output: 2
    }
}

/*  SPACE OPTIMIZED TABULATION
    public int minInsertions(String s) {
        int n = s.length();
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        if(s.equals(s2)) return 0;

        int[] prev = new int[n+1];
        for(int i = 1; i <= n; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }

        int lcs = prev[n];
        return n - lcs;
    }
  */