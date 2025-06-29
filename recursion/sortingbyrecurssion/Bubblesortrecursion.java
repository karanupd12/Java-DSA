/*
 * this is how we do bubble sort using recursion, we use the same approach as of pattern i.e; treating length of array as no. of columns and a single row as 0
 * 
 * concept - swapping while traversing the entire row(an array is a single row matrix)
 */

package recursion.sortingbyrecurssion;

import java.util.Arrays;

public class Bubblesortrecursion {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        bubble(arr, 0 , arr.length-1);     //traversing the entire array recursively
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr , int s , int e) {
        if (e == 0) {
            return;
        }
        if (s < e) {
            // swap and continue
            if (arr[s] > arr[s + 1]) {
                int temp = arr[s];
                arr[s] = arr[s + 1];
                arr[s + 1] = temp;
            }
            bubble(arr, s + 1 , e);
        } else {
            // continue without any swapping
            bubble(arr, 0 , e - 1);
        }
    }
}
