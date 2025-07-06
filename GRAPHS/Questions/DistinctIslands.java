package GRAPHS.Questions;
import java.util.*;

/*
Problem : https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0

Approach : Use DFS to traverse each island, marking visited cells and recording the shape of the island in a string format.
The string representation captures the relative movements (down, right, up, left) and backtracking, allowing us to identify distinct shapes.
*/

public class DistinctIslands {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[] move = {'D', 'R', 'U', 'L'};

    int countDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, vis, sb, 'S');
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    void dfs(int[][] grid, int i, int j, boolean[][] vis, StringBuilder sb, char dirChar){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] == true || grid[i][j] == 0) return;
        vis[i][j] = true;
        sb.append(dirChar);
        for(int d = 0; d < 4; d++){
            dfs(grid, i + dir[d][0], j + dir[d][1], vis, sb, move[d]);
        }
        sb.append('B');             // backtrack - this helps in distinguishing the shape of the island
    }
}
