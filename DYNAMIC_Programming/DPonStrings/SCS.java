package DYNAMIC_Programming.DPonStrings;

/*
Problem : https://leetcode.com/problems/shortest-common-supersequence/
Problem Statement: Given two strings s1 and s2, return the shortest string that has both s1 and s2 as subsequences.

Approach : Use LCS to find the length of the longest common subsequence (LCS) between the two strings.
          - The length of the shortest common supersequence (SCS) can be calculated as:
            SCS length = (length of s1 + length of s2 - length of LCS).
          - Construct the SCS by traversing through both strings and appending characters accordingly.
*/

public class SCS {
    public static String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] >= dp[i][j-1]){  //came from above (so we need s1 chars not s2)
                    sb.append(s1.charAt(i-1));
                    i--;
                }else{
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        //because of one based indexing
        while(i > 0) sb.append(s1.charAt(--i));
        while(j > 0) sb.append(s2.charAt(--j));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        String scs = shortestCommonSupersequence(s1, s2);
        System.out.println("Shortest Common Supersequence: " + scs); // Output: "AGGXTXAYB"
    }
}
