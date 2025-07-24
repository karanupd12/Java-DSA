package DYNAMIC_Programming.DPonLIS;
import java.util.*;
/*
Problem - https://leetcode.com/problems/longest-increasing-subsequence/
A very straightforward dp tabulation algorithm just for LIS
dp[i] max lis possible upto that index
TC: O(NxN) SC: O(N)
USED for easy LIS printing through trackback using a parent array
*/
public class LISAlgorithm {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[prev]+1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
