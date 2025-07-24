package DYNAMIC_Programming.DPonLIS;

/*
Problem - https://leetcode.com/problems/longest-increasing-subsequence/
this is just a dp on subseq type solution, do not use it , it feels hard, use another tabulation alsorithm approach (LISAlgotrithm.java)
because that will help you even in (PrintLIS as well), and if only LIS length has been asked , do LIS using Binary search algo
*/
public class LIStabulation {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--){
            for(int prev = i-1; prev >= -1; prev--){
                int take = 0;
                if(prev == -1 || nums[i] > nums[prev]){
                    take = 1 + dp[i+1][i+1];
                }
                int notTake = dp[i+1][prev+1];
                dp[i][prev+1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}

/*
public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return lis(0, -1, nums, dp);
    }

    private int lis(int i, int prev, int[] nums, int[][] dp){
        if(i == nums.length) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]){
            take = 1 + lis(i+1, i, nums, dp);
        }
        int notTake = 0 + lis(i+1, prev, nums, dp);

        return dp[i][prev+1] = Math.max(take , notTake);
    }
 */
