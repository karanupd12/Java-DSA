package DYNAMIC_Programming.CoinChange;

//Tabulation method(bottom up) - non recursive - good for large amount

import java.util.Arrays;

public class CoinChange2 {

    public static int minCoins(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int amt = 1; amt <= amount; amt++){
            for(int coin : coins){
                if(amt >= coin){
                    dp[amt] = Math.min(dp[amt], dp[amt-coin]+1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(minCoins(coins, amount));
    }
}
