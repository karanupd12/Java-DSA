package DYNAMIC_Programming.DPonLIS;

import java.util.Arrays;

/*
Problem - https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
Intution :
- We compute the Longest Increasing Subsequence (LIS) ending at each index and the Longest Decreasing Subsequence (LDS) starting from each index.
- A valid bitonic sequence must strictly increase then decrease, so we only consider positions where both LIS and LDS are > 1.
- By merging these at every valid peak (LIS[i] + LDS[i] - 1), we extract the maximum length of a true bitonic subsequence.
*/

class LongestBitonicSubseq {
    public static int LongestBitonicSequence(int n, int[] nums) {
        if (nums == null || n == 0) return 0;

        int[] inc = new int[n]; // LIS ending at i
        int[] dec = new int[n]; // LDS starting at i

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);

        // Compute LIS from left to right
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]) {
                    inc[i] = Math.max(inc[i], inc[p] + 1);
                }
            }
        }

        // Compute LDS from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int p = n - 1; p > i; p--) {
                if (nums[p] < nums[i]) {
                    dec[i] = Math.max(dec[i], dec[p] + 1);
                }
            }
        }

        // Compute the maximum bitonic subsequence length
        int maxBitonicLen = 0;
        for (int i = 0; i < n; i++) {
            // Valid bitonic peak must have both increasing and decreasing parts
            if (inc[i] > 1 && dec[i] > 1) {
                maxBitonicLen = Math.max(maxBitonicLen, inc[i] + dec[i] - 1);
            }
        }

        return maxBitonicLen;
    }
}
