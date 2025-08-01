package GRAPHS.ShortestPath;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis, (int)1e8);
        dis[src] = 0;

        for(int i = 0; i < V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dis[u] != (int)1e8 && dis[u] + w < dis[v]){
                    dis[v] = dis[u] + w;
                }
            }
        }

        boolean hasCycle = false;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dis[u] != (int)1e8 && dis[u] + w < dis[v]){
                hasCycle = true;
                break;
            }
        }

        if(hasCycle) return new int[]{-1};
        else return dis;

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

        int[] result = bellmanFord(V, edges, 0);
        for(int num : result) System.out.print(num);

    }
}
