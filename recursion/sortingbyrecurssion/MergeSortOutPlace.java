package recursion.sortingbyrecurssion;

import java.util.Arrays;

public class MergeSortOutPlace {

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){   //simple method to merge to arrays into a new array
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, k = 0;
        while(l < left.length && r < right.length){
            if(left[l] <= right[r]) 
                merged[k] = left[l++];
            else
                merged[k] = right[r++];
            k++;
        }
        while(l < left.length) merged[k++] = left[l++];  //if right is finsied but left is'nt
        while(r < right.length) merged[k++] = right[r++]; //if right is finished but left is'nt
        return merged;
    }

    public static void main(String[] args) {
        int[] testArray = {
            105, 3, -45, 0, 78, 256, -500, 89, 6, 47, 120, -1, 95, 203, 402, 8, 67, -305, 0, 78, 63, 7, 402,
            -89, 64, 1000, 523, -99, 700, 8, 150, -76, 95, 32, 3, 400, 222, -100, 76, 89, 54, 45, -45, 900, 
            200, 601, 803, -300, 400, 2, 1, 67, 900, 0, 110, -405, 56, 8, 45, 999, -1, 76, 77, 400, 45, -200
        };

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(testArray));

        int[] ans = mergeSort(testArray);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(ans));
    }
}
