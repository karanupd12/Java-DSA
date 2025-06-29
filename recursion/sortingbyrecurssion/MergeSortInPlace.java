package recursion.sortingbyrecurssion;

import java.util.Arrays;

public class MergeSortInPlace {

    public static int[] copy;
    public static void mergeSort(int[] arr){
        copy = new int[arr.length];
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int s, int e){
        if(s >= e) return;
        int mid = s+(e-s)/2;     // mid
        sort(arr, s , mid);      //sort left half
        sort(arr, mid+1, e);     //sort right half
        merge(arr, s, mid, e);   //merge both halves
    }

    public static void merge (int[] arr, int s, int mid, int e){
        int i = s, j = mid+1;
        for(int k = s; k <= e; k++){           //copy whole array to copy array
            copy[k] = arr[k];
        }

        for(int k = s; k <= e; k++){
            if(i > mid) arr[k] = copy[j++];                    //left half exhausted. take from right
            else if(j > e) arr[k] = copy[i++];                 //right half exhausted, take from left
            else if(copy[j] < copy[i]) arr[k] = copy[j++];     //current key on right < current key on left , take from right
            else arr[k] = copy[i++];
        }
    }
    
    public static void main(String[] args) {
        int[] testArray = {
            105, 3, -45, 0, 78, 256, -500, 89, 6, 47, 120, -1, 95, 203, 402, 8, 67, -305, 0, 78, 63, 7, 402,
            -89, 64, 1000, 523, -99, 700, 8, 150, -76, 95, 32, 3, 400, 222, -100, 76, 89, 54, 45, -45, 900, 
            200, 601, 803, -300, 400, 2, 1, 67, 900, 0, 110, -405, 56, 8, 45, 999, -1, 76, 77, 400, 45, -200
        };
        mergeSort(testArray);
        System.out.println( Arrays.toString(testArray));
    }
}



/*
 * Merge Sort : Merge sort is a divide-and-conquer sorting algorithm that divides the input array into two halves, recursively sorts them, and then merges the two sorted halves into a single sorted array.
 * It has a time complexity of O(n log n) in the best, worst, and average cases.
 * Done via recursion
 */


 // step1 : divide array into two parts
 // step2 : get both part sorted via recursion resp.
 // step3 : sort both part w.r.t to each other, merge accordingly both parts.
 
 //method 1 :- we can divide the array into two different arrays and then sort them as two unique arrays, compare both arrays and merge them (new array will be returned, orignal array is not modified )
 
 //method 2 (in place method):- we dont'n need to form two new arrays, we can find middle element and consider start - mid as one part and mid - end as other half of the array and sort them though indexes and later compare and merge them within the same array(no need to return new array (orignal array is modified)
