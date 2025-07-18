package DYNAMIC_Programming.DPonStrings;
import java.util.*;
/*
Problem Statement: https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1
Find all possible Longest Common Subsequences (LCS) between two strings in lexicographical order:

Intution: Build dp table using LCS tabulation approach
Then, use backtracking to find all LCS sequences by exploring all paths in the dp table that lead to the LCS length from
the bottom-right cell to the top-left cell.
- Backtrack with memoization to avoid recomputing already found LCS sequences.

* */

public class AllPossibleLCS {
    public List<String> allLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> set = backtrack(m, n, s1, s2, dp, memo);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);         // Sort the result to get lexicographical order or yo can use TreeSet instead of HashSet
        return ans;
    }

    private Set<String> backtrack(int i, int j, String s1, String s2, int[][] dp, Map<String, Set<String>> memo){
        Set<String> res = new HashSet<>();

        if(i == 0 || j == 0){
            res.add("");
            return res;
        }

        String key = i+","+j;
        if(memo.containsKey(key)) return memo.get(key);

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            for(String lcs : backtrack(i-1, j-1, s1, s2, dp, memo)){
                res.add(lcs + s1.charAt(i-1));
            }
        }
        else{
            if(dp[i-1][j] >= dp[i][j-1]){
                res.addAll(backtrack(i-1, j, s1, s2, dp, memo));
            }
            if(dp[i-1][j] <= dp[i][j-1]){
                res.addAll(backtrack(i, j-1, s1, s2, dp, memo));
            }
        }

        memo.put(key, res);
        return res;
    }
}
