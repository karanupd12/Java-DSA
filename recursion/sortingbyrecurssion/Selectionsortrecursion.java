package recursion.sortingbyrecurssion;

import java.util.Arrays;

public class Selectionsortrecursion {
    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
        selection(arr, arr.length , 0, 0); // traversing the entire array by taking a max element & comparing it to
        System.out.println(Arrays.toString(arr));   // all elements
    }

    static void selection(int[] arr, int r, int c, int max) { // max=index of max element selected
        if (r == 0) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[max]) {                    //now max element is the element at indec c
                selection(arr, r, c+1, c);
            }
            else{                                       //continue with the same element as max
                selection(arr, r, c+1, max);
            }
        }
        else {                                           //swap with last element and continue with new row
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selection(arr, r-1, 0, 0);
        }
    }
}
