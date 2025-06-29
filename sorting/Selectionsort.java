/*
 * Selection Sort : Selection sort is a sorting algorithm that repeatedly finds the minimum/maximum element from the unsorted part of the list and swaps it with the first/last unsorted element. This process is repeated until the entire list is sorted.
 * total no. of comparisions made = n-1 
 * It has a time complexity of O(n^2) in the worst and average cases.
 * it performs well in small lists
 */



import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 0};
        selection(arr);
        System.out.print(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < arr.length ; j++) {         //this is loop is selecting the smallest element
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            // swap                                          //smallest element is being placed at first position 
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            }
        }
    }
}