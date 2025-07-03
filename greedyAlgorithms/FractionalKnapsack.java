package greedyAlgorithms;
import java.util.*;


/*
*Problem : Given weights and values of n items and a knapsack with capacity W, fill the knapsack to get the maximum total value, allowing fractions of items.

* Intuition / Core Idea
- Unlike 0/1 knapsack, we can take fractions of items.
- To maximize value, pick items with the highest value-to-weight ratio (value/weight) first.
-Greedy choice: take the item with max value/weight, take full if possible, else take the fraction that fits.
*/

class Item implements Comparable<Item> {
    int val, wt;
    Item(int val, int wt){
        this.val = val;
        this.wt = wt;
    }

    @Override
    public int compareTo(Item other) {
        double ratio1 = (double)this.val / (double)this.wt;
        double ratio2 = (double)other.val / (double)other.wt;
        if(ratio1 == ratio2) return 0;
        return (ratio1 < ratio2) ? 1 : -1;
    }
}

public class FractionalKnapsack {
    static double fractionalKS(Item[] items, int W){
        Arrays.sort(items);

        int currWt = 0;
        double maxVal = 0.0;

        for(Item item : items){
            if(currWt + item.wt <= W){
                currWt += item.wt;
                maxVal += item.val;
            }
            else{
                int remain = W - currWt;
                maxVal += ((double)item.val / (double)item.wt) * (double)remain;
                break;
            }
        }

        return maxVal;
    }


    public static void main(String[] args) {
        Item[] items = {
                new Item(100, 20) {},
                new Item(60, 10) {},
                new Item(100, 50) {},
                new Item(200, 50) {},
        };

        int W = 90; // Maximum weight capacity of the knapsack
        double maxValue = fractionalKS(items, W);

        System.out.println("Maximum value in Knapsack = " + maxValue);  //60+100+200+((100*10)*50) = 380.0
    }
}
