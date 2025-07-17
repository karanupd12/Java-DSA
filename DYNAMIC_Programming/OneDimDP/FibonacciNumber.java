package DYNAMIC_Programming.OneDimDP;

/*
Problem Statement: https://leetcode.com/problems/fibonacci-number/

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1.
The sequence commonly starts as follows: 0, 1, 1, 2, 3, 5, 8, 13, 21, and so on.

recurrence relation: fib(n) = fib(n-1) + fib(n-2)
Brute Force -> Memoization -> tabulation -> space optimization
*/

class FibonacciNumber {
    //BEST APPROACH, SPACE OPTIMIZED : O(1)
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int last = 1, secondLast = 0;
        for(int i = 2; i < n+1; i++){
            int curr = last + secondLast;
            secondLast = last;
            last = curr;
        }
        return last;
    }
}

/*
    TABULATION : TC:O(N), SC:O(N)

    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


 */
/*
    MEMOIZATION : TC:O(N), SC:O(N)+O(N)

    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = solve(n-1, dp) + solve(n-2, dp);
        return dp[n];
    }
*/