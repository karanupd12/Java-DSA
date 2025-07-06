package GRAPHS.Questions;
import java.util.*;

/*
Problem :- https://leetcode.com/problems/course-schedule-ii/
Approach :- This problem can be solved using topological sorting. We can use Kahn's algorithm which uses BFS to find the
topological order of the directed graph formed by the courses and their prerequisites.
* */


public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // Build directed graph and find indegree
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        // Initialize queue with nodes having zero indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.offer(i);

        // Process nodes
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int nei : adj.get(curr)) {
                if (--indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        // If result contains all courses, no cycle exists, return the topological sorted courses, else return empty array
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return res.size() == numCourses ? ans : new int[]{};
    }
}
