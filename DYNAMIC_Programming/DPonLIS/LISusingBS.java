package DYNAMIC_Programming.DPonLIS;
import java.util.*;
/*
Problem - https://leetcode.com/problems/longest-increasing-subsequence/submissions/1709639020/
Approach :
-We build a list to track the smallest last numbers of increasing sequences.
-If the current number is bigger than all in the list, we add it (sequence gets longer).
-Otherwise, we replace the first number that's bigger or equal — to keep chances open for future longer sequences.

Now the list is not the longest increasing subseq but the size of this list is our answer, so use this code only if size is asked, otherwise use
(LISAlgorithm.java)
TC : O(NlogN)
SC : O(N)
*/

public class LISusingBS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int index = findPosition(lis, num);

            if (index == lis.size()) {
                lis.add(num); // Extend the sequence
            } else {
                lis.set(index, num); // Replace to maintain minimal end values
            }
        }

        return lis.size();
    }

    // Binary search: find lowerBound :  find first index >= target
    private int findPosition(List<Integer> lis, int target) {
        int low = 0, high = lis.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (lis.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}
