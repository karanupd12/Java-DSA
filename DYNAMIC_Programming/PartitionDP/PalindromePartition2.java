package DYNAMIC_Programming.PartitionDP;

import java.util.Arrays;


/*
Problem - https://leetcode.com/problems/palindrome-partitioning-ii/
Approach:
We use forward partitioning with memoization to minimize cuts.
At each index 'i', we check all substrings s[i...j]. If it's a palindrome, we cut after 'j' and solve the rest.
We recursively compute the minimum number of cuts required and cache results using dp[].
Subtract 1 at the end since the last palindrome doesn't need a cut.

Time Complexity: O(N^2) – N substrings checked, each taking O(N) for palindrome checking.
Space Complexity: O(N) – for the dp[] array.
*/

public class PalindromePartition2 {
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        if(n == 0 || isPalindrome(0, n-1, s)) return 0;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n, s) - 1;
    }

    private int solve(int i, int n, String s){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int minCuts = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i, j, s)){
                int cuts = 1 + solve(j+1, n, s);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return dp[i] = minCuts;
    }

    private boolean isPalindrome(int l, int r, String str) {
        while(l < r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}
