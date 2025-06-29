package GRAPHS.CycleDetection;

//This code is for detecting a cycle in an undirected graph using Depth First Search (DFS).
// It works by visiting each node of the graph and checking its neighbors:

//  1. A boolean array tracks visited nodes. Starting from any unvisited node, the code explores all its neighbors.
//  2. If it encounters a node that’s already visited and is not the parent of the current node, a cycle is detected.
//  3. The graph might have multiple components, so it checks each unvisited node to ensure all parts of the graph are covered.
//  4. The dfsForCycle function uses recursion to explore neighbors. It passes the current node as the "parent" to avoid treating backtracking as a cycle.
//  5. If any part of the graph contains a cycle, the program immediately returns true; otherwise, it concludes that the graph is cycle-free.

import java.util.ArrayList;
import java.util.List;

public class CDinUndirectedGraph {

    // Function to detect cycle in an undirected graph
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && hasCycle(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, adj, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        // Uncomment the next line to introduce a cycle
        // adj.get(4).add(1); adj.get(1).add(4);


        // Check if the graph contains a cycle & print result
        boolean hasCycle = isCycle(V, adj);

        System.out.println("Does the graph contain a cycle? " + hasCycle);
    }
}
