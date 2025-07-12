package DYNAMIC_Programming.DPonGrids;

/*
Problem Statement: https://leetcode.com/problems/unique-paths/
Unique Paths I is a classic dynamic programming problem where you need to find the number of unique paths from the top-left corner
to the bottom-right corner of a grid, moving only down or right.
Recursion -> Memoization -> Tabulation -> Space Optimization

Unique paths 2 : https://leetcode.com/problems/unique-paths-ii/
just add obstacle check in the above code(if cell is obstacle skip it)
*/

public class UniquePaths1 {
    //Most intutive approach: Tabulation (Bottom-Up DP)
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1; // Only 1 way to reach any cell in the first row or first column
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Sum of paths from top and left cells
                }
            }
        }
        return dp[m-1][n-1];
    }
}


/*

Space Optimized : Space Efficient (O(n) instead of O(m*n))
 public int uniquePaths(int m, int n) {
    int[] prev = new int[n];
    Arrays.fill(prev, 1);

    for(int i = 1; i < m; i++) {
        int[] curr = new int[n];
        curr[0] = 1;
        for(int j = 1; j < n; j++) {
            curr[j] = curr[j-1] + prev[j];
        }
        prev = curr;
    }
    return prev[n-1];
}
*/

/*
Recursion + Memoization
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(0, 0, m, n, dp);
    }

    (we can also go from m-1, n-1 to 0,0 - this is just a different way to think , both are correct)
    private int dfs(int i, int j, int m, int n, int[][] dp){
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(i == m-1 && j == n-1) return 1;
        int down = dfs(i+1, j, m, n, dp);
        int right = dfs(i, j+1,  m, n, dp);
        return dp[i][j] = down + right;
    }

*/
/*
Recursion : Brute force : not good
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        int down = dfs(i+1, j, m, n);
        int right = dfs(i, j+1,  m, n);
        return down + right;
    }
*/