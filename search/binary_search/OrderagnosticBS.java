//Order agnostic binary search is done when we do not know whether the array is sorted in asc or in desc manner.
// So, first we find the manner of sorted array and then search our target element using same conditional statements
// as in binary search.

package search.binary_search;

public class OrderagnosticBS {
    public static void main(String[] args) {
        int[] arr={99, 87, 65, 45, 32, 21, 19, 13, 7, -2, -5, -16, -20, -34};
        int target = -2;
        System.out.println(orderAgnosticBS(arr , target));
    }

    public static int orderAgnosticBS(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;

        //this is to check whether our arr is sorted in increasing or decreasing order
        boolean isAsc= arr[start]<arr[end];

        while (start <= end){
            //finding the middle element
            //int mid =(start+end)/2; --- might be possible that (start+end) exceeds the range of int in java , so better way is :
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                return mid;                // index at which target is found
            }

            if (isAsc){                    //true -- if ascending array
                if (target < arr[mid]){
                    end = mid-1;              
                }
                else{
                    start = mid+1;
                }

            }else{                         //false -- if descending array
                if (target > arr[mid]){
                    end = mid-1;              
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;      
    }
}
