package GRAPHS.ShortestPath;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    public int isNegWeightedCycle(int V, int[][] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];
                if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }

        // For checking cycle - just repeat the above edge iteration one more time
        for (int j = 0; j < edges.length; j++) {
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];
            if (dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]) {
                return 1; // Relaxation is possible, so cycle exists
            }
        }

        return 0; // No negative-weight cycle
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Define edges in the format {source, destination, weight}
        int[][] edges = {
                {0, 1, -1},
                {0, 2, 4},
                {1, 2, 3},
                {1, 3, 2},
                {1, 4, 2},
                {3, 2, 5},
                {3, 1, 1},
                {4, 3, -3}
        };

        BellmanFordAlgorithm bfa = new BellmanFordAlgorithm();
        int result = bfa.isNegWeightedCycle(V, edges);

        if (result == 1) {
            System.out.println("The graph contains a negative-weight cycle.");
        } else {
            System.out.println("The graph does not contain a negative-weight cycle.");
        }
    }
}
