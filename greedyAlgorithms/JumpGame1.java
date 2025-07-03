package greedyAlgorithms;
import java.util.*;

/*
Jump Game - https://leetcode.com/problems/jump-game/
Approach :- We can use a greedy approach to determine if we can reach the end of the array.
We iterate through the array and keep track of the farthest index we can reach.
If at any point, the farthest index we can reach is less than the current index, we cannot reach the end.
If we reach the end of the array, we can return true.
*/

public class JumpGame1 {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxReach > nums.length-1) return true;
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
