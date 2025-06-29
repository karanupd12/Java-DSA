package GRAPHS.ShortestPath;
import java.util.*;

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

public class DijkstraAlgorithm {

    public static int[] shortestPath(int V, int Src, List<List<Pair>> adj){
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(Src, 0));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); //denotes infinity dist initially
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
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int Src = 0; // Source vertex

        // Create adjacency list representation of the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u → v with weight w)
        adj.get(0).add(new Pair(1, 2)); // Edge 0 → 1 with weight 2
        adj.get(0).add(new Pair(3, 6)); // Edge 0 → 3 with weight 6
        adj.get(1).add(new Pair(2, 3)); // Edge 1 → 2 with weight 3
        adj.get(1).add(new Pair(3, 8)); // Edge 1 → 3 with weight 8
        adj.get(1).add(new Pair(4, 5)); // Edge 1 → 4 with weight 5
        adj.get(2).add(new Pair(4, 7)); // Edge 2 → 4 with weight 7
        adj.get(3).add(new Pair(4, 9)); // Edge 3 → 4 with weight 9

        // Call the shortestPath function
        int[] distances = shortestPath(V, Src, adj);

        // Print the shortest distance
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + distances[i]);
        }
    }
}
