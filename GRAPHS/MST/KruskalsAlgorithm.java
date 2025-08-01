package GRAPHS.MST;


import java.util.Arrays;

public class KruskalsAlgorithm {

    static int[] par;
    static int[] rank;
    static int kruskalsMST(int V, int[][] edges) {
        par = new int[V];
        rank = new int[V];
        for(int i = 0; i < V; i++){
            par[i] = i;
            rank[i] = 0;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]); //sort by weight
        int mst = 0;

        for(int[] edge : edges){    //take each edge, if not formas cycle, add it (do union then)
            int a = find(edge[0]);
            int b = find(edge[1]);

            if(a != b){
                mst += edge[2];
                union(edge[0], edge[1]);
            }
        }
        return mst;
    }

    private static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(rank[x] < rank[y]){
            par[x] = y;
        }
        else if(rank[a] > rank[b]){
            par[x] = y;
        }
        else{
            par[y] = x;
            rank[x]++;
        }
    }
}
