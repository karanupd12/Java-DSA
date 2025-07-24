package DYNAMIC_Programming.DPonLIS;
import java.util.*;

/*
Same LIS algo approach, just an extra string check is required
*/

public class LongestStringChain {
    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

            int[] dp = new int[words.length];
            Arrays.fill(dp, 1);

            int max = 1;
            for(int i = 1; i < words.length; i++){
                for(int pre = 0; pre < i; pre++){
                    if(isValid(words[pre], words[i]) && dp[i] < dp[pre] + 1){
                        dp[i] = dp[pre] + 1;
                    }
                }
                if(dp[i] > max) max = dp[i];
            }

            return max;
        }

        private boolean isValid(String s1, String s2){
            int n1 = s1.length(), n2 = s2.length();
            if(n2 != n1+1) return false;
            int count = 0;
            int i = 0, j = 0;
            while(i < n1 && j < n2){
                if(count == 2) break;
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                    count++;
                }
            }
            if(count >= 2) return false;
            return true;
        }
    }
}
