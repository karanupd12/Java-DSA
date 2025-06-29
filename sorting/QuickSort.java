import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partition(arr, lo, hi);
        sort (arr, lo, pivot - 1);
        sort (arr, pivot + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];   //first element as pivot
        int s = lo+1;          //start from the element next to pivot
        int e = hi;

        while (s <= e) {
            //move s to right until an element >= pivot is found
            while (s <= hi && arr[s] < pivot) s++; 
            //move e to left until an element <= pivot is found
            while (e > lo && arr[e] > pivot) e--;
            //swap element at s and e if s <= e
            if(s <= e){
                swap(arr, s, e);
                s++;
                e--;
            }
        }

        swap(arr, lo, e);     //place pivot element at correct position
        return e;             //'e' is the final position of pivot
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {
            105, 3, -45, 0, 78, 256, -500, 89, 6, 47, 120, -1, 95, 203, 402, 8, 67, -305, 0, 78, 63, 7, 402,
            -89, 64, 1000, 523, -99, 700, 8, 150, -76, 95, 32, 3, 400, 222, -100, 76, 89, 54, 45, -45, 900, 
            200, 601, 803, -300, 400, 2, 1, 67, 900, 0, 110, -405, 56, 8, 45, 999, -1, 76, 77, 400, 45, -200
        };
        quickSort(testArray);
        System.out.println( Arrays.toString(testArray));
    }
}
