package DYNAMIC_Programming.DPonStrings;

/*
Problem : https://geeksforgeeks.org/longest-common-substring-dp-29/
Problem Statement: find longest common substring between two strings.

Approach : tabulation - make usual dp[m+1][n+1] table, where m and n are lengths of two strings.
                      - iterate through both strings, if characters match, then dp[i][j] = dp[i-1][j-1] + 1
                      - if characters do not match, then dp[i][j] = 0
                      - track each state using max variable and return it at the end.
*/

public class LCSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "zcdemf";
        System.out.println("Longest Common Substring Length: " + longestCommonSubstring(s1, s2));
    }
}
