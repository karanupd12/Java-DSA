package DYNAMIC_Programming.DPonGrids;

/*

Problem Statement: https://leetcode.com/problems/minimum-path-sum/
Minimum Path Sum is a dynamic programming problem where you need to find the path from the top-left corner to the bottom-right
corner of a grid.
The path should minimize the sum of the values along the path, moving only down or right.
Recursion -> Memoization -> Tabulation -> Space Optimization
*/

public class MinPathSum {
    //Most simple intutive Tabulation DP
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j = 1; j < n; j++) dp[0][j] = grid[0][j] + dp[0][j-1];

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
        return dp[m-1][n-1];
    }
}

/*
 Simple recursion :
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return dfs(m-1, n-1, grid);
    }

    private int dfs(int i, int j, int[][] grid, int[][] memo){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[i][j];
        int up = dfs(i-1, j, grid);
        int left = dfs(i, j-1, grid);
        return grid[i][j] + Math.min(up, left);
    }
*/

/*  MEMOIZATION :
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        return dfs(m-1, n-1, grid, memo);
    }

    private int dfs(int i, int j, int[][] grid, int[][] memo){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[i][j];
        if(memo[i][j] != 0) return memo[i][j];
        int up = dfs(i-1, j, grid, memo);
        int left = dfs(i, j-1, grid, memo);
        return memo[i][j] = grid[i][j] + Math.min(up, left);
    }

*/

/*  SPACE OPTIMIZATION :
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for(int i = 1; i < n; i++) prev[i] = grid[0][i] + prev[i-1];

        for(int i = 1; i < m; i++){
            int[] curr = new int[n];
            curr[0] = grid[i][0] + prev[0];
            for(int j = 1; j < n; j++){
                curr[j] = grid[i][j] + Math.min(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n-1];
    }
*/

/*
In-place : Directly modify the grid : no extra space
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0 && j > 0)
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                else if(i > 0)
                    grid[i][j] += grid[i-1][j];
                else if(j > 0){
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
 */


