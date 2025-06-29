package GRAPHS.CycleDetection;


/*
This program uses Depth First Search (DFS) to traverse the graph. To detect cycles, it maintains a recursion stack alongside the visited array.
The recursion stack keeps track of vertices in the current recursive call path. If a vertex is encountered that is already in the recursion stack, a cycle is detected.

Algorithm Explanation:
-Start DFS from an unvisited vertex.
-Mark the vertex as visited and add it to the recursion stack.
-Explore all neighbors of the current vertex. If a neighbor is unvisited, recursively call DFS on it. If the neighbor is in the recursion stack, a cycle is detected.
-After exploring all neighbors, remove the vertex from the recursion stack.

The recursion stack acts as a record of the current DFS path. If a vertex points to another vertex already in the stack, it implies we’ve found a back edge,
completing a cycle. Without this stack, we might misinterpret forward edges or cross edges as cycles, leading to incorrect results.
*/

import java.util.ArrayList;
import java.util.List;

public class CDinDirectedGraph {

    // Function to detect cycle in a directed graph
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V]; // Tracks visited nodes
        boolean[] rec = new boolean[V]; // Tracks nodes currently in the recursion stack
        for (int i = 0; i < V; i++) {
            if (!vis[i] && hasCycle(i, adj, vis, rec)) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle found
    }

    private static boolean hasCycle(int node, List<List<Integer>> adj, boolean[] vis, boolean[] rec) {
        vis[node] = true; // Mark the node as visited
        rec[node] = true; // Add the node to the recursion stack
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (hasCycle(neighbor, adj, vis, rec)) return true;
            } else if (rec[neighbor]) {
                return true; // Cycle detected
            }
        }
        rec[node] = false; // Remove the node from the recursion stack
        return false; // No cycle detected for this path
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0); // Introduces a cycle
        adj.get(2).add(3);

        // Check if the directed graph contains a cycle
        boolean hasCycle = isCycle(V, adj);

        // Print the result
        System.out.println("Does the directed graph contain a cycle? " + hasCycle);
    }
}
