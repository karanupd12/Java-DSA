package greedyAlgorithms;
import java.util.*;


/*
Problem Statement: Given a list of job durations representing the time it takes to complete each job. Implement the
Shortest Job First algorithm to find the average waiting time for these jobs.

Approach: We implement the Shortest Job Duration First algorithm using the Greedy technique by selecting the shortest job
from the array. To always select the shortest job first we sort the job duration array in ascending order based on their duration.

Once the jobs are sorted, we iterate through each job in the sorted list. For each iteration the waiting time is the sum
of the total time taken by all previous jobs. We calculate the waiting time for each job and update the total time taken
by adding the duration of the current job to the total waiting time.
*/

public class SJF {
    static float shortestJobFirst(int[] jobs) {
        Arrays.sort(jobs);

        float waitTime = 0, totalTime = 0;
        int n = jobs.length;

        for (int i = 0; i < n; ++i) {
            waitTime += totalTime;
            totalTime += jobs[i];
        }

        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        float ans = shortestJobFirst(jobs);
        System.out.println("Average waiting time: " + ans);
    }
}
