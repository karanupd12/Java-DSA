package GRAPHS;

/*
 * This code provides the following functionality:
 * 1. Determines whether it is possible to reach the destination vertex from the source vertex.
 * 2. If reachable, computes the shortest distance from the source to the destination (or any other vertex) using the dist[] array.
 * 3. Prints the shortest path from the source to the destination by backtracking through the pred[] array.
 * 4. Counts the number of connected components in the graph by performing BFS multiple times, tracking visited vertices with the visited[] array.
 */


import java.util.*;

public class Graph_BFS {

    public static boolean GraphBFS(List<List<Integer>> adj, int src, int dest, int[] dist, int[] pred, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(visited, false);   // initially, no vertex is visited
        Arrays.fill(dist, 0);         // initially, dist from src to each vertex is 0
        Arrays.fill(pred, -1);        // initially, the predecessor of every vertex is null

        visited[src] = true;          // Starting from src, so mark it as visited
        dist[src] = 0;                // dist of src to src is 0
        queue.offer(src);             // add src to queue

        // start traversing until queue is not empty
        while (!queue.isEmpty()) {
            int curr = queue.poll();       // take out the curr from queue
            int n = adj.get(curr).size();  // no. of neighbors curr has
            // check for all neighbors
            for (int i = 0; i < n; i++) {
                // this will only run if neighbor is not visited before
                int neighbor = adj.get(curr).get(i);
                if (!visited[neighbor]) {
                    visited[neighbor] = true;         // mark neighbor as visited
                    dist[neighbor] = dist[curr] + 1;  // this updates the dist b/w src and neighbor
                    pred[neighbor] = curr;            // the predecessor of neighbor is obviously curr
                    queue.add(neighbor);              // add neighbor to queue
                    // check if neighbor is our destination
                    if (neighbor == dest) return true;
                }
            }
        }
        return false;  // even after traversing whole graph, we couldn't reach dest, then return false
    }

    public static void printShortestPath(int src, int dest, int[] pred) {
        List<Integer> path = new ArrayList<>();
        int crawl = dest;
        path.add(crawl);

        // Traverse back using the predecessor array
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Reverse the path to get the correct order from src to dest
        Collections.reverse(path);

        System.out.print("Shortest path from " + src + " to " + dest + ": ");
        for (int vertex : path) {
            System.out.print(vertex + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Initialize adjacency list
        int V = 6; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(3).add(5);
        adj.get(5).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        int[] pred = new int[V];

        int src = 0, dest = 5; // Source and destination vertices

        boolean isReached = GraphBFS(adj, src, dest, dist, pred, visited);

        if (isReached) {
            System.out.println("Shortest distance from " + src + " to " + dest + " is: " + dist[dest]);
            printShortestPath(src, dest, pred);
        } else {
            System.out.println(dest + " is unreachable from " + src);
        }

        // For counting the number of connected components
        int components = 0;
        Arrays.fill(visited, false); // Reset visited array
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                GraphBFS(adj, i, -1, dist, pred, visited);
            }
        }
        System.out.println("No. of connected components: " + components);
    }
}
