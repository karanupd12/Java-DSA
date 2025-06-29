package DYNAMIC_Programming;

//Memoization method - uses memo[] to store ans of already calculated - good for small amount

import java.util.Arrays;

public class CoinChange1 {

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1); // Initialize memoization array
        return minCoins(coins, amount, memo);
    }

    private static int minCoins(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;   // Base case: No coins needed for 0 amount
        if (amount < 0) return Integer.MAX_VALUE; // Impossible case
        if (memo[amount] != -1) return memo[amount]; // Return already computed result

        int minC = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subAns = minCoins(coins, amount - coin, memo);
            if (subAns != Integer.MAX_VALUE) { // Avoid overflow
                minC = Math.min(minC, subAns + 1);
            }
        }
        memo[amount] = minC;

        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result); // Output: 3
    }
}
