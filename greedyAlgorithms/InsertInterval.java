package greedyAlgorithms;
import java.util.*;

/*
Insert Interval - https://leetcode.com/problems/insert-interval/
Approach :- we will iterate through the intervals and check if the new interval overlaps with the current interval.
then, we will merge the intervals by updating the start and end of the new interval.
Finally, we will add the new interval to the result and add rest of the intervals to the result as well.
*/

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
