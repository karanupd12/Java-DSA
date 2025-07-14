package DYNAMIC_Programming.DPonGrids;

/*

Problem Statement: https://leetcode.com/problems/cherry-pickup-ii/
Cherry Pickup II is a dynamic programming problem where you need to collect the maximum number of cherries from a grid.
Two robots start at the top row and can move down to the bottom row, collecting cherries along the way.
The robots can move in any direction(downLeft, down, downRight), and the goal is to maximize the total number of cherries collected.

Approach: Recursion -> Memoization -> Tabulation -> Space Optimization

Intution 3d DP: Think of it as a 3D DP problem where you have two robots and their positions in the grid.

The state can be represented as dp[i][j1][j2], where i is the current row, j1 is the column of the first robot, and
j2 is the column of the second robot. i is same because both robots are moving down the same row.

*/


public class CherryPickup2 {
    int[] dir = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for(int j1 = 0; j1 < n; j1++){
            for(int j2 = 0; j2 < n; j2++){
                dp[m-1][j1][j2] = (j1 == j2) ? grid[m-1][j1] : grid[m-1][j1] + grid[m-1][j2];
            }
        }

        for(int i = m-2; i >= 0; i--){
            for(int j1 = 0; j1 < n; j1++){
                for(int j2 = 0; j2 < n; j2++){
                    int maxCherries = Integer.MIN_VALUE;;
                    for(int d1 : dir){
                        for(int d2 : dir){
                            int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            if(j1+d1 >= 0 && j1+d1 < n && j2+d2 >= 0 && j2+d2 < n){
                                val += dp[i+1][j1+d1][j2+d2];
                            }else{
                                val += Integer.MIN_VALUE;
                            }
                            maxCherries = Math.max(maxCherries, val);
                        }
                    }
                    dp[i][j1][j2] = maxCherries;
                }
            }
        }

        return dp[0][0][n-1];
    }
}


/*
 MEMOIZATION
    int[] dir = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] memo = new int[m][n][n];
        for(int[][] arr : memo){
            for(int[] a : arr) Arrays.fill(a, -1);
        }
        return dfs(0, 0, n - 1, m, n, grid, memo);
    }

    private int dfs(int i, int j1, int j2, int m, int n, int[][] grid, int[][][] memo) {
        // Boundary check
        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n)
            return Integer.MIN_VALUE;

        // Base case: last row
        if (i == m - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        //if already calculated , return it
        if(memo[i][j1][j2] != -1) return memo[i][j1][j2];

        // Explore all 3x3 combinations of moves for both robots
        int maxCherries = Integer.MIN_VALUE;
        for (int d1 : dir) {
            for (int d2 : dir) {
                int cellVal = 0;
                if(j1 == j2) cellVal = grid[i][j1];
                else cellVal = grid[i][j1] + grid[i][j2];
                int next = dfs(i + 1, j1 + d1, j2 + d2, m, n, grid, memo);
                maxCherries = Math.max(maxCherries, cellVal + next);
            }
        }
        //save and return
        return memo[i][j1][j2] = maxCherries;
    }


  */



/*
RECURSION :
    int[] dir = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return dfs(0, 0, n - 1, m, n, grid);
    }

    private int dfs(int i, int j1, int j2, int m, int n, int[][] grid) {
        // Boundary check
        if (j1 < 0 || j2 < 0 || j1 >= n || j2 >= n)
            return Integer.MIN_VALUE;

        // Base case: last row
        if (i == m - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxCherries = Integer.MIN_VALUE;

        // Explore all 3x3 combinations of moves for both robots
        for (int d1 : dir) {
            for (int d2 : dir) {
                int next = dfs(i + 1, j1 + d1, j2 + d2, m, n, grid);
                if (next != Integer.MIN_VALUE) {
                    int current = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                    maxCherries = Math.max(maxCherries, current + next);
                }
            }
        }

        return maxCherries;
    }
 */