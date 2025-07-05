package GRAPHS.Questions;

/*
Problem : https://leetcode.com/problems/number-of-enclaves/
Approach : DFS from the boundary cells to mark all reachable land cells as water, then count the remaining land cells.
*/

public class NoOfEnclaves {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        //first & last row
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1) dfs(grid, 0, j);
            if(grid[m-1][j] == 1) dfs(grid, m-1, j);
        }
        //first & last col;
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][n-1] == 1) dfs(grid, i, n-1);
        }

        int lands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) lands++;
            }
        }

        return lands;
    }

    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        for(int[] d : dir){
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
