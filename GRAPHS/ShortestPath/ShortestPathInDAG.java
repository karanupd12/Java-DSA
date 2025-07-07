package GRAPHS.ShortestPath;
import java.util.*;

/*
Problem: https://www.geeksforgeeks.org/shortest-path-in-a-directed-acyclic-graph/
Approach: The shortest path in a Directed Acyclic Graph (DAG) can be found using a modified BFS or topological sort.

- Initialize a distance array with infinity.
- Use a queue to process nodes starting from the source node (0).
- For each node, update the distances of its neighbors if a shorter path is found.

Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
*/

public class ShortestPathInDAG {

    public int[] shortestPath(int V, int E, int[][] edges) {
        if(edges == null) return new int[]{};

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Create adjacency list: each node stores a list of {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        // BFS-style queue: stores {node, current distance}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0], currDist = curr[1];

            for(int[] nei : adj.get(u)){
                int v = nei[0], wgt = nei[1];
                // Relaxation step: if a shorter path to v is found
                if(dist[v] > currDist + wgt){
                    dist[v] = currDist + wgt;
                    q.offer(new int[]{v, dist[v]});
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
