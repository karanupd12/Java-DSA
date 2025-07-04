package GRAPHS.Questions;

/*
Problem  : https://leetcode.com/problems/flood-fill/
Approach : DFS(recommended) or BFS
*/

public class FloodFill {
    //using DFS
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        dfs(image, sr, sc, color, original);
        return image;
    }

    private void dfs(int[][] g, int x, int y, int color, int original){
        if(x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == color || g[x][y] != original) return;
        g[x][y] = color;
        for(int[] d : dir){
            dfs(g, x + d[0], y + d[1], color, original);
        }
    }
}






/* using BFS : not recommended for this problem, but still a valid approach
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int original = image[sr][sc];
        if(original == color) return image;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            image[x][y] = color;

            for(int[] d : dir){
                int i = x + d[0], j = y + d[1];
                if(i >= 0 && j >= 0 && i < m && j < n && image[i][j] != color && image[i][j] == original){
                    q.offer(new int[]{i, j});
                }
            }
        }
        return image;
    }
 */
