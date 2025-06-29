package recursion.arraysinrecurssion;

public class LSinRecurssion {
    public static void main(String[] args) {
        int[] arr = { 12, 23, 34, 45, 56, 67, 78, 89 };
        int target = 45;
        System.out.println(checking(arr, target, 0));    //true  
        System.out.println(findindex(arr, target, 0));   //3
    }


    //this is to check if element is present or not in arr
    static boolean checking(int[] arr, int target, int index) {
        // base condition
        if (index == arr.length - 1) {
            return false;
        }
        return arr[index] == target || checking(arr, target, index + 1);
    }


    //this is to find index of target element
    static int findindex(int[] arr, int target, int index){
        // base condition
        if (index == arr.length - 1) {
            return -1;
        }
        if (arr[index] == target){
            return index;
        }
        else{
            return findindex(arr, target, index + 1);
        }
    }
}
