package recursion.sortingbyrecurssion;
/*
 * Quick Sort : Quick sort is a divide-and-conquer sorting algorithm that selects a pivot element and partitions the array into two sub-arrays, one with elements less than the pivot and another with elements greater than the pivot. This process is recursively applied to the sub-arrays until the entire array is sorted.
 * It has best and average time complexity of O(n log n) and a worst-case time complexity of O(n^2).
 */

import java.util.Arrays;

class Quicksort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = arr[m]; // we can take any element as pivot, i have taken middle element as pivot.

        while (s <= e) {
            while (arr[s] < pivot) { // no violation , continue
                s++;
            }

            while (arr[e] > pivot) { // no violation , continue
                e--;
            }

            if (s <= e) { // this will run to remove both left and right violations (by swapping around pivot)
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // now pivot is at correct position, now sort the both parts around pivot
        sort(arr, low, e);
        sort(arr, s, hi);
    }
}