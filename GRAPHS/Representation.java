package GRAPHS;
// We have 2 major representations for a graph
// 1. Adjacency matrix - for dense graphs , space - O(V^2)
// 2. Adjacency List - for sparse graphs , space - O(V+E)

import java.util.ArrayList;
import java.util.List;

public class Representation {

    public static void addEdge(int[][] adjMatrix, int source, int dest){
        adjMatrix[source][dest] = 1;
        adjMatrix[dest][source] = 1;
    }

    public static void addEdge(List<List<Integer>> adjList, int source, int dest){
        adjList.get(source).add(dest);
        adjList.get(dest).add(source);
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 10;

        //Adjacency matrix (given V, E, Source, destination)
        int[][] adjMatrix = new int[v+1][v+1];

        //Adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        addEdge(adjList,0,1);
        addEdge(adjList,0,2);
        addEdge(adjList,1,3);
        addEdge(adjList,1,4);
        addEdge(adjList,2,4);
        addEdge(adjList,3,5);

    }
}
