package GRAPHS.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;
 //same as DFS traversal in graph, we just maintain a visited stack
public class Dfs {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!stack.isEmpty())
            ans[i++] = stack.pop();

        return ans;
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                dfs(neighbor, adj, vis, stack);
            }
        }
        stack.push(v); //adding v to stack when all its neighbors are visited
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] result = topoSort(V, adj);

        System.out.println("Topological Sort:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}

























