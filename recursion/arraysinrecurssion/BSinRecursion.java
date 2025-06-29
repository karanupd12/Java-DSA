//this is how we do binary search using recursion

package recursion.arraysinrecurssion;

public class BSinRecursion {
    public static void main(String[] args) {
        int[] arr = {23, 45, 49, 56, 67, 78, 89, 93, 98};
        System.out.println(search(arr, 89, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {                    //base case 1 : target not found
            return -1;
        }

        int m = s + (e - s) / 2;        // middle element

        if (arr[m] == target) {         //base case 2 : target found at middle
            return m;                   
        }
        if (target < arr[m]) {          // target is on left side of middle element
            return search(arr, target, s, m - 1); // the new end = m-1
        }
        // otherwise , target is on right side of middle element
        return search(arr, target, m + 1, e); // the new start = m+1
    }
}
