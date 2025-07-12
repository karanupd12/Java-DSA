package DYNAMIC_Programming.DPonGrids;
import java.util.*;

/*
* Problem Statement: https://leetcode.com/problems/triangle/
* Triangle is a dynamic programming problem where you need to find the minimum path sum from the top to the bottom of a triangle.
* We can only move down or down right.
* Approach: Recursion -> Memoization -> Tabulation -> Space Optimization
*This is just like a grid question but only triangle fillings are there, so think of it as a grid with some cells missing.
* */

//we are moving starting from last row to first row, because its a triangle, we will get the answer on dp[0][0] after filling the dp array
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < i+1; j++){   // j can go from 0 to i, because its a triangle (not your usual square matrix)
                if(i == n-1){
                    dp[i][j] = triangle.get(i).get(j);
                }
                else{
                    int down = dp[i+1][j];
                    int downRight = dp[i+1][j+1];
                    dp[i][j] = triangle.get(i).get(j) + Math.min(down, downRight);
                }
            }
        }
        return dp[0][0];
    }
}

/*
RECURSION : BRUTE FORCE : try all paths from top to bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(0, 0, triangle);
    }

    private int dfs(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size()) return 0;
        int down = dfs(i + 1, j, triangle);
        int downRight = dfs(i + 1, j + 1, triangle);
        return triangle.get(i).get(j) + Math.min(down, downRight);
    }
 */

 /*
MEMOIZATION :
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, n, triangle, dp);
    }

    private int dfs(int i, int j, int n, List<List<Integer>> triangle, int[][] dp){
        if(i == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = dfs(i+1, j, n, triangle, dp);
        int downRight = dfs(i+1, j+1, n, triangle, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, downRight);
    }
*/

/*
//Space Optimized approach - O(N) space
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n+1];
            for(int j = 0; j < n; j++) dp[j] = triangle.get(n-1).get(j);

            for(int i = n-2; i >= 0; i--){
                for(int j = 0; j <= i; j++){
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }
            return dp[0];
        }
*/

