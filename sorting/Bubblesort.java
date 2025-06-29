/*
 * Bubble Sorting : Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent
 *       elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.
 * total no. of comparisions made = n-1
 * It has a time complexity of O(n^2) in the worst and average cases.
 */



import java.util.Arrays;

public class Bubblesort{
    public static void main(String[] args) {
        int[] arr={23, -45, 42, -89, 69, 12, -53, 27};
        bubble(arr);
        System.out.print(Arrays.toString(arr));    
    }

    static void bubble(int[] arr){
        boolean swapped;
    //run the steps n-1 times
        for(int i=0 ; i<arr.length ; i++){
            swapped = false;
            for(int j=1 ; j<arr.length-i ; j++){                   //for each step, max item will come at the last respective index
                if (arr[j]<arr[j-1]){                              //swap if the item is smaller than the previous item
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //if you did not swap for a particular value of i, it means the array is sorted . hence, stop the loop
            //this will run if swap didi'nt happen
            if (!swapped){    //or swapped == false
                break;
            }
        }
    }
}