/*
 * Insertion Sort : Insertion sort is a sorting algorithm that builds the final sorted list one item at a time. It iterates over the list and for each element, it finds its correct position in the sorted part of the list and inserts it. 
 * It has a time complexity of O(n^2) in the worst and average cases.
 * its adaptive , stable and is used for smaller value of n
 * works good when array is partially sorted , that's why it takes part in hybrid sorting algorithm
 */


import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 0 };
        insertion(arr);
        System.out.print(Arrays.toString(arr));
    }

    static void insertion(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
