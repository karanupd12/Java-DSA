package GRAPHS.ShortestPath;
import java.util.*;


/*
For single source shortest path in a weighted graph with non-negative weights, we can use Dijkstra's algorithm.
This algorithm uses a priority queue to efficiently get the next vertex with the smallest distance.
TC: O(E log V) where E is the number of edges and V is the number of vertices.
*/


public class DijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {
        //building a graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0], v = e[1], wt = e[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while(!pq.isEmpty()){
            int u = pq.poll()[0];
            if(!vis[u]){
                vis[u] = true;
                for(int[] neigh : adj.get(u)){
                    int v = neigh[0], w = neigh[1];
                    if(dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }
        }

        return dist;
    }
}
