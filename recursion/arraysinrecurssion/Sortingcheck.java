//checking whether an array is sorted or not using recurssion

package recursion.arraysinrecurssion;

public class Sortingcheck {
    public static void main(String[] args) {
        int arr1[] = { 12, 56, 78, 90, 98, 99 };
        int arr2[] = { 12, 56, 12, 78, 90, 98 };

        System.out.println(issorted(arr1, 0)); // true
        System.out.println(issorted(arr2, 0)); // false

    }

    public static boolean issorted(int arr[], int index) {
        // base condition
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && issorted(arr, index + 1);
    }
}