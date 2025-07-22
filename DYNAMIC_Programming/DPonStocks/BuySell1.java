package DYNAMIC_Programming.DPonStocks;

/*
Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Problem Statement: You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Follow greedy approach to find the minimum price so far and calculate the maximum profit at each step.
No dp is needed for this problem, because we only need to keep track of the minimum price and maximum profit.
*/

public class BuySell1 {
    //greedy
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int num : prices){
            if(num > min){
                maxProfit = Math.max(maxProfit, num - min);
            }else{
                min = num;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 5, // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5
    }
}
