package heaps;
import java.util.*;
public class HeapSort {

    public static void heapsort(int[] arr){
        int n = arr.length;
        // Build heap (rearrange array)
        int i = n / 2 - 1;
        while (i >= 0) {
            heapify(arr, n, i);
            i--;
        }
        //extract element from heap one by one
        int ilast = n - 1;
        while(ilast > 0){
            // move current root to end
            swap(arr, 0, ilast);
            // call MaxHeapify on the reduced heap
            heapify(arr, ilast, 0);
            ilast--;
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]
    private static void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        //if left child is larger than root
        if (left < n && arr[left] > arr[max]){
            max = left;
        }
        //of right child is larger than root so far
        if (right < n && arr[right] > arr[max]){
            max = right;
        }
        //if i is not max anymore
        if (max != i){
            swap(arr, i, max);
            //continue heapify the subtree
            heapify(arr, n, max);
        }
    }

    // swap function
    private static void swap(int arr[], int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 45, 6, 73, 22, 11 };
        heapsort(arr);
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
