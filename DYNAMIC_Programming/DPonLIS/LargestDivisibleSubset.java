package DYNAMIC_Programming.DPonLIS;
import java.util.*;
/*
Problem : https://leetcode.com/problems/largest-divisible-subset/description/

Intution : as we know order doesn't matter, so we can sort array(for ease of comparison), rest we can apply the PrintLIS.java Algorithm
because we need to trace back to print subset
*/
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums);
        int[] dp = new int[n];      //dp[i] represents the previous
        int[] prev = new int[n];    //store parent indexes
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int current = maxIdx;
        while (current != -1) {
            result.add(nums[current]);
            current = prev[current];
        }

        Collections.reverse(result);
        return result;

    }
}
