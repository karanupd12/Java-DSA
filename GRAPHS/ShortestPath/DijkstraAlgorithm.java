package GRAPHS.ShortestPath;
import java.util.*;


/*
For single source shortest path in a weighted graph with non-negative weights, we can use Dijkstra's algorithm.
This algorithm uses a priority queue to efficiently get the next vertex with the smallest distance.
TC: O(E log V) where E is the number of edges and V is the number of vertices.
*/


public class DijkstraAlgorithm {

    class Pair implements Comparable<Pair> {
        int vertex;
        int weight;
        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair that) {
            return this.weight - that.weight;
        }
    }

    public int[] shortestPath(int V, int Src, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); //denotes infinity dist initially

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(Src, 0));
        dist[Src] = 0;  //dist from src to src will obviously be 0

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int u = cur.vertex;
            if(!vis[u]){
                vis[u] = true;
                for(Pair neighbor : adj.get(u)){
                    int v = neighbor.vertex;
                    int wt = neighbor.weight;
                    //relaxation
                    if(dist[v] > dist[u] + wt){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }
}
