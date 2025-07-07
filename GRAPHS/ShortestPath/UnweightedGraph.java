package GRAPHS.ShortestPath;
import java.util.*;

/*
Problem: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
Approach : shortest path from source(or multiSource) to all other vertices in an unweighted graph can be found using BFS.
- unweighted means each edge has unit weight (1).

Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
*/

public class UnweightedGraph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        if (adj == null || src < 0 || src >= adj.size()) return new int[0];

        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        while(!q.isEmpty()){
            int v = q.poll();
            for(int nei : adj.get(v)){
                if(dist[nei] > dist[v] + 1){
                    dist[nei] = dist[v] + 1;
                    q.offer(nei);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
