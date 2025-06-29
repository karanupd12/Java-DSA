package DYNAMIC_Programming;

import java.util.Arrays;

public class LCS {

    //Memoization - top down (recursion + memo[][])
    public static int lcs1(String s1, String s2, int m, int n, int[][] memo) {
        if(m == 0|| n == 0)                           // Base case: If either string is empty, LCS is 0
            return 0;

        if(memo[m][n] != -1)                          // If already computed, return stored value
            return memo[m][n];

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
