package GRAPHS.MST;

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

public class PrimsAlgorithm {

    public static int spanningTree(int V, List<List<Pair>> adj) {
        boolean[] vis = new boolean[V]; // Tracks visited vertices
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Min-heap for selecting the edge with minimum weight
        pq.add(new Pair(0, 0)); // Start from vertex 0 with weight 0

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;

            if (!vis[u]) {
                vis[u] = true; // Mark this vertex as visited
                mstWeight += curr.weight;

                // Add all unvisited neighbors of 'u' to the priority queue
                for (Pair neighbor : adj.get(u)) {
                    if (!vis[neighbor.vertex]) {
                        pq.add(neighbor);
                    }
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 5; // Example number of vertices
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph input
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(3, 6));
        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(2).add(new Pair(1, 3));
        adj.get(2).add(new Pair(4, 7));
        adj.get(3).add(new Pair(0, 6));
        adj.get(3).add(new Pair(1, 8));
        adj.get(4).add(new Pair(2, 7));

        System.out.println("Weight of MST: " + spanningTree(V, adj));
    }
}
