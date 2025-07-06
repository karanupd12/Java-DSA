package GRAPHS.Questions;
import java.util.*;

/*
Problem: https://leetcode.com/problems/course-schedule/

Approach: This problem can be easily solved using DFS to detect cycles in a directed graph. If a cycle is detected,
it means that it's impossible to finish all courses due to circular dependencies.
- If you want order of courses(topologically sorted), you can use Kahn's Algorithm(refer - CourseSchedule2.java).
*/

// Note: This is a classic problem of detecting cycles in a directed graph using DFS.

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] p : prerequisites) adj.get(p[1]).add(p[0]);

        boolean[] vis = new boolean[n];  //vis array
        boolean[] recSt = new boolean[n];   //recursion stack

        for(int i = 0; i < n; i++){
            if(!vis[i] && hasCycle(i, adj, vis, recSt)) return false;
        }

        return true;
    }

    private boolean hasCycle(int v, List<List<Integer>> adj, boolean[] vis, boolean[] recSt){
        vis[v] = true;
        recSt[v] = true;

        for(int nei : adj.get(v)){
            if(!vis[nei] && hasCycle(nei, adj, vis, recSt)) return true;
            else if(recSt[nei] == true) return true;
        }

        recSt[v] = false;  //for next recursion, backtrack
        return false;
    }
}
