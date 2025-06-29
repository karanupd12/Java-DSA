package GRAPHS;

/*
This code is much simpler than BFS, we just have to apply dfs recursively for every neighbor we encounter
and mark it as visited at the same time
For a vertes,
1. mark vis[vertex] = true
2. for all its unvisited neighbors - apply dfs(......)

In graph BFS, do not get confused because i have used loop to connected components as well at the time.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_DFS {

    public static int components = 0;

    public static ArrayList<Integer> graphDFS(int V, List<List<Integer>> adj){
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();   //dfs traversal
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                components++;
                dfs(i, adj, vis, ans);
            }
        }
        return ans;
    }

    private static void dfs(int v, List<List<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[v] = true;
        ans.add(v);
        for (int neighbor : adj.get(v)){
            if (!vis[neighbor]){
                dfs(neighbor, adj, vis, ans);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        // Initialize adjacency list for each vertex
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        // Add edges to the graph (undirected)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);

        List<Integer> ans = graphDFS(V, adj);
        System.out.println("DFS traversal of graph is: " + ans);

        //for counting connected components
        System.out.println("Connected components: " + components);
    }

}
