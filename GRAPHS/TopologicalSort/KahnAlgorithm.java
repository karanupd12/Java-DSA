package GRAPHS.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgorithm {

    public static List<Integer> topoSort(Integer V, List<List<Integer>> adj){
        //calculating indegree of vertices
        int[] inDeg = new int[V];
        for(List<Integer> list : adj){
            for(int e : list){
                inDeg[e]++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        bfs(adj, V, inDeg, ans);

        return ans;
    }

    private static void bfs(List<List<Integer>> adj, Integer V, int[] inDeg, List<Integer> ans) {
        Queue<Integer> queue = new LinkedList<>();
        for(int v = 0; v < V; v++){
            if(inDeg[v] == 0) queue.offer(v);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);

            for(int neighbor : adj.get(curr)){
                if(--inDeg[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> result = topoSort(V, adj);

        System.out.println("Topological Sort: " + result);
    }
}
