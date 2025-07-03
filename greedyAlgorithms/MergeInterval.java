package greedyAlgorithms;
import java.util.*;

/*
Approach :- we maintain a prev interval and compare it with the current interval.
If the current interval overlaps with the previous one, we merge them by updating the end of the previous interval.
If it does not overlap, we add the previous interval to the merged list and update the previous interval to the current one.
Finally, we add the last interval to the merged list.
*/

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> merged = new ArrayList<>();

        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
