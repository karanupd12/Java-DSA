package DYNAMIC_Programming.DPonLIS;
import java.util.*;
/*
Problem - https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1
Using LIS tabulation algorithm and keeoing trak of last index ina parent array to track back and print LIS
*/
public class PrintLIS {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] p = new int[n];

        Arrays.fill(dp, 1); //because we know 1 lis is alway possible ()
        Arrays.fill(p, -1); //no parent for now

        int lis = 1;
        int lastIdx = 0;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                //setting up dp & parent array if conditions of subseq holds
                if(arr[prev] < arr[i] && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    p[i] = prev;
                }
            }
            if(dp[i] > lis){
                lis = dp[i];
                lastIdx = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(lastIdx != -1){
            list.add(arr[lastIdx]);
            lastIdx = p[lastIdx];
        }

        Collections.reverse(list);
        return list;
    }
}
