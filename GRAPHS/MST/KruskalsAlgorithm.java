package GRAPHS.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int src, dest, wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge that) { // Sorted in ascending order by weight
        return this.wt - that.wt;
    }
}

public class KruskalsAlgorithm {

    static int[] p, rank;

    // Find with path compression
    static int find(int v) {
        if (p[v] != v) {
            p[v] = find(p[v]); // Path compression
        }
        return p[v];
    }

    // Union with rank
    static void union(int u, int v) {
        int rootOfu = find(u);
        int rootOfv = find(v);

        if (rootOfu == rootOfv)
            return;

        if (rank[rootOfu] < rank[rootOfv])
            p[rootOfu] = rootOfv;
        else if (rank[rootOfu] > rank[rootOfv])
            p[rootOfv] = rootOfu;
        else {
            p[rootOfv] = rootOfu;
            rank[rootOfu]++;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[][] added = new boolean[V][V];
        ArrayList<Edge> edges = new ArrayList<>();

        // Build the edge list from the adjacency list
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                ArrayList<Integer> curr = adj.get(i).get(j);
                if (!added[i][curr.get(0)]) {
                    added[i][curr.get(0)] = true;
                    added[curr.get(0)][i] = true;
                    Edge edge = new Edge(i, curr.get(0), curr.get(1));
                    edges.add(edge);
                }
            }
        }

        // Initialize DSU
        p = new int[V];
        rank = new int[V];
        for (int v = 0; v < V; v++) {
            p[v] = v; // Initially, each vertex is its own parent
            rank[v] = 0; // Initially, all ranks are 0
        }

        // Sort edges by weight
        Collections.sort(edges);

        int edgeCount = 0; // Edges added to MST
        int mstWeight = 0; // Weight of the MST

        // Process edges
        for (int i = 0; i < edges.size() && edgeCount < V - 1; i++) {
            Edge edge = edges.get(i);
            int rootOfSrc = find(edge.src);
            int rootOfDest = find(edge.dest);

            if (rootOfSrc != rootOfDest) { // Add edge if it doesn't form a cycle
                union(rootOfSrc, rootOfDest);
                edgeCount++;
                mstWeight += edge.wt;
            }
        }

        return mstWeight;
    }

    // Main function
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adj.get(0).add(new ArrayList<>(List.of(1, 1))); // Edge (0, 1) with weight 1
        adj.get(1).add(new ArrayList<>(List.of(0, 1)));

        adj.get(1).add(new ArrayList<>(List.of(2, 2))); // Edge (1, 2) with weight 2
        adj.get(2).add(new ArrayList<>(List.of(1, 2)));

        adj.get(0).add(new ArrayList<>(List.of(2, 3))); // Edge (0, 2) with weight 3
        adj.get(2).add(new ArrayList<>(List.of(0, 3)));

        adj.get(2).add(new ArrayList<>(List.of(3, 4))); // Edge (2, 3) with weight 4
        adj.get(3).add(new ArrayList<>(List.of(2, 4)));

        // Call spanningTree and print the MST weight
        System.out.println("Weight of the Minimum Spanning Tree: " + spanningTree(V, adj));
    }
}
