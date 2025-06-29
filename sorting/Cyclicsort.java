/*
 * Cyclic sort : cyclic sort is an in-place sorting algorithm that works well when the input consists of integers in a small range. It repeatedly places each element in its correct position by swapping it with the element at that position until the entire array is sorted. 
 * It has a time complexity of O(n) in the best, worst, and average cases.
 * sorts the array in one single loop
 * use CYCLIC SORT when no's are in range of 1 to N 
 * 
 * (0th index = 1, 1st index = 2, 2nd index = 3,......, (n-1)th index = N)  
 */

import java.util.Arrays;

public class Cyclicsort {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 1, 5, 3};
        cyclicsort(arr);                                 // INDEX  :  0   1   2   3   4   5
        System.out.println(Arrays.toString(arr));        // OUTPUT : [1 , 2 , 3 , 4 , 5 , 6]
    }

    public static void cyclicsort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;         // Calculate the correct index for the current element
            if (arr[i] != arr[correctIndex]) {     // Check if the element is not already at its correct position
                //swap
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;          // Swap the elements
            } else {
                i++;                               // Move to the next element if it is already at its correct position
            }
        }
    }
}
