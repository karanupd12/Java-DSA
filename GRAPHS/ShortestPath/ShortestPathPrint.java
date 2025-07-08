package GRAPHS.ShortestPath;
import java.util.*;

/*
- printing the complete shortest path from source to destination in a weighted undirected graph.(using dijkstra's algorithm)
- maintain a parent array to reconstruct the path after finding the shortest distances.(by crawling back from destination to source)
*/

public class ShortestPathPrint {
    class Pair implements Comparable<Pair> {
        int vertex, weight;
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) parent[i] = i;

        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;
            for (Pair nei : adj.get(u)) {
                int v = nei.vertex, wt = nei.weight;
                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // If unreachable
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // Reconstruct path from n to 1
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
