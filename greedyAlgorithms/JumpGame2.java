package greedyAlgorithms;
import java.util.*;

// Jump Game II - https://leetcode.com/problems/jump-game-ii/
/*
Approach :- We move through the array and keep track of the farthest we can go.
When we reach the end of the current jump, we make a jump and set a new end.
This way, we always take the fewest jumps needed to reach the end.
*/

public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, far = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                jumps++;
                end = far;
            }
        }

        return jumps;
    }
}
