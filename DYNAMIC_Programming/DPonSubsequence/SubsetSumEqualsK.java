package DYNAMIC_Programming.DPonSubsequence;

/*
Problem Statement: https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
Subset Sum Equals K is a classic dynamic programming problem where you need to determine if there exists a subset of a
given array whose sum equals a given target value K.

Approach: Recursion -> Memoization -> Tabulation -> Space Optimization
Intuition: Think of it as a decision-making problem where you decide whether to include or exclude each element in the subset.
Apply memoization to avoid redundant calculations.
Then convert it to tabulation for a bottom-up approach.
Finally, optimize the space complexity by using a single array instead of a 2D array.
*/

public class SubsetSumEqualsK {
    static Boolean isSubsetSum(int[] arr, int sum) {
        Boolean[][] memo = new Boolean[arr.length][sum+1];
        return dfs(arr.length-1, sum, arr, memo);
    }

    static boolean dfs(int i, int target, int[] arr, Boolean[][] memo) {
        if (target == 0) return true;
        if (i < 0 || target < 0) return false;
        if(memo[i][target] != null) return memo[i][target];
        boolean take = (arr[i] <= target)? dfs(i+1, target-arr[i], arr, memo) : false;
        boolean notTake = dfs(i+1, target, arr, memo);
        return memo[i][target] = take || notTake;
    }
}


/*
TABULATION + SPACE OPTIMIZED
    static Boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum+1];

        prev[0] = true;

        if (arr[0] <= sum) prev[arr[0]] = true;

        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int target = 1; target <= sum; target++){
                boolean notTake = prev[target];
                boolean take = (arr[i] <= target) ? prev[target-arr[i]] : false;
                curr[target] = take || notTake;
            }
            prev = curr;
        }

        return prev[sum];
    }
*/

/*
TABULATION
    static Boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];

        for(int i = 0; i < n; i++) dp[i][0] = true; // 0 sum is always possible

        if (arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notTake = dp[i-1][target];
                boolean take = (arr[i] <= target) ? dp[i-1][target-arr[i]] : false;
                dp[i][target] = take || notTake;
            }
        }

        return dp[n-1][sum];
    }
*/