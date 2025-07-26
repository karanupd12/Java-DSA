package DYNAMIC_Programming.PartitionDP;

import java.util.Arrays;

//Problem - https://leetcode.com/problems/burst-balloons/

public class BurstBaloon {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;

        //Make new array 'arr' by Adding 1 before and after the original array
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i = 0; i < n; i++) arr[i+1] = nums[i];

        //dp of size arr
        dp = new int[n+2][n+2];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(1, n, arr);
    }

    //partiton dp logic
    private int solve(int i, int j, int[] arr){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int cost = arr[i-1] * arr[k] * arr[j+1];
            int total = cost + solve(i, k-1, arr) + solve(k+1, j, arr);
            max = Math.max(max, total);
        }

        return dp[i][j] = max;
    }
}
