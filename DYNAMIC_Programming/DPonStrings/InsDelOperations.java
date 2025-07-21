package DYNAMIC_Programming.DPonStrings;

/*
Problem : https://leetcode.com/problems/delete-operation-for-two-strings/description/
Problem Statement: Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
each operation can be a deletion of a character in either string.

Approach : Use lcsLength = LCS(word1, word2), to find longest common subsequence (we need to make both string lcs now)
                         - find how many left in word1 to delete (m - lcsLength)
                         - find how many left in word2 to delete (n - lcsLength)
                         - answer = (m - lcsLength) + (n - lcsLength)
*/

public class InsDelOperations {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table for LCS
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of longest common subsequence
        int lcsLength = dp[m][n];

        // Minimum operations required to make both strings equal
        return (m - lcsLength) + (n - lcsLength);
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum number of steps to make the strings equal: " + minDistance(word1, word2)); // Output: 2
    }
}
