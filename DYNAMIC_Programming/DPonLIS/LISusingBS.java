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
    public static int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int index = lowerBound(lis, num);

            if (index == lis.size()) {
                lis.add(num); // Extend the sequence
            } else {
                lis.set(index, num); // Replace to maintain minimal end values
            }
        }

        return lis.size();
    }

    // Binary search: find lowerBound :  find first index >= target
    private static int lowerBound(List<Integer> list, int target){
        int s = 0, e = list.size()-1, res = list.size();
        while(s <= e){
            int mid = s+(e-s)/2;
            if(list.get(mid) >= target){
                res = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 3, 11, 7, 15};
        System.out.println(lengthOfLIS(arr));   // 3; i.e; [10, 11, 15]
    }

}
