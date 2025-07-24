package DYNAMIC_Programming.DPonLIS;
import java.util.*;

/*
Intution :
- For each index i, we track the length (dp[i]) and count (cnt[i]) of the longest increasing subsequences ending at i.
- If a previous element p is smaller and gives a longer LIS, we update the length and reset count.
- If it gives an equally long LIS, we add its count, since multiple paths can lead to the same LIS length.
 */

public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];   // dp[i] = length of LIS ending at i
        int[] cnt = new int[n];  // cnt[i] = number of LIS ending at i

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]) {
                    if (dp[p] + 1 > dp[i]) {
                        dp[i] = dp[p] + 1;
                        cnt[i] = cnt[p]; // reset count
                    } else if (dp[p] + 1 == dp[i]) {
                        cnt[i] += cnt[p]; // add to count
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                total += cnt[i];
            }
        }

        return total;
    }
}
