package GRAPHS.ShortestPath;
import java.util.*;

/*
Problem : Finding the shortest path in a binary matrix.

Shortest path in a matrix can be solved using various algorithms depending on the constraints and properties of the matrix.
This is an example of finding the shortest path in a binary matrix (0s and 1s) using BFS. from (0, 0) to (n-1, n-1).
- Use BFS to explore all possible paths.
- Each cell can be traversed if it is 0 (open cell).
- The BFS will explore all 8 possible directions (up, down, left, right, and the 4 diagonals).
*/

public class InMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // row, col, distance
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            if (r == n - 1 && c == n - 1) return d;

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }
        return -1;
    }
}
