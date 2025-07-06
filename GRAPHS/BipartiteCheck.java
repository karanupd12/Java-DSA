package GRAPHS;
import java.util.Arrays;

/*
Bipartite graph - A bipartite graph is a graph whose vertices can be divided into two disjoint sets such that no two graph
vertices within the same set are adjacent, (no two vertices can be colored with the same color).

Problem: https://leetcode.com/problems/is-graph-bipartite/
Approach: Use Two-Coloring technique with DFS. Go through each node, color it with one color, and try to color all its
neighbors with the opposite color. If a neighbor is already colored with the same color, then the graph is not bipartite.
*/


public class BipartiteCheck {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(!isValidColoring(i, 0, graph, color, vis)) return false;
            }
        }

        return true;
    }

    private boolean isValidColoring(int v, int c, int[][] graph, int[] color, boolean[] vis){
        vis[v] = true;
        color[v] = c;
        for(int neigh : graph[v]){
            if(!vis[neigh]){
                if(!isValidColoring(neigh, 1-c, graph, color, vis)) return false;
            }else{
                if(color[neigh] == color[v]) return false;
            }
        }
        return true;
    }
}
