package greedyAlgorithms;
import java.util.*;

// Candy - https://leetcode.com/problems/candy/

public class Candies {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        //from left to right, assign candies w.r.t left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        //from right to left, assign candies w.r.t right neighbor, but update it max(w.r.t left, w.r.t right), to make sure both are satified
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        //sum of all candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
