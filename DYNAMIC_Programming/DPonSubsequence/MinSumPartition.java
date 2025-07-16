package DYNAMIC_Programming.DPonSubsequence;


/*
Problem Statement: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
Given an array of integers, the task is to partition the array into two subsets such that the difference between their sums is minimized.

Approach: Build a DP table where dp[i][j] indicates whether a sum j can be formed using the first i elements of the array.
Then, find the minimum difference by checking all possible sums that can be formed with the given elements.

*/


public class MinSumPartition {
    public int minDifference(int arr[]) {
        int totalSum = 0, n = arr.length;
        for(int num : arr) totalSum += num;

        boolean[][] dp = new boolean[n][totalSum+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;

        if(arr[0] <= totalSum) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= totalSum; target++){
                boolean take = (arr[i] <= target) ? dp[i-1][target-arr[i]] : false;
                boolean notTake = dp[i-1][target];
                dp[i][target] = take || notTake;
            }
        }

        // Find the minimum difference by checking the last row of the dp table because it contains all possible sums that can be formed with the given elements.
        int minDiff = Integer.MAX_VALUE;
        for(int sum1 = 0; sum1 <= totalSum/2; sum1++){
            if(dp[n-1][sum1] == true){
                int sum2 = totalSum - sum1;
                int diff = Math.abs(sum1 - sum2);
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }
}
