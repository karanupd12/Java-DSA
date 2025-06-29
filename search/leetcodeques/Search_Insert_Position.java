package search.leetcodeques;

public class Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {

        //checking for existence of target in nums
        boolean found = false;
        for (int i = 0; i < nums.length; i++){
            if (target == nums[i]){
                found = true;
                break;
            }
        }
        //if found then apply BS function
        if (found){
            return bssearch (nums, target);
        }
        //if not existe, return the index where it should belong
        else{
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > target) {
                    return i;
                }
            }
            return nums.length ;
        }
    }

    public static int bssearch (int[] nums, int target){
        int s = 0;
        int e = nums.length - 1;
        while (s <= e){
            int m = s+(e-s)/2;
            if (target < nums[m])
                e = m - 1;
            else if (target > nums[m])
                s = m + 1;
            else
                return m;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8};
        int target1 = 1;
        int target2 = 6;
        int target3 = 11;

        System.out.println(searchInsert(arr, target1));  //1 - insertion
        System.out.println(searchInsert(arr, target2));  //3 - only search
        System.out.println(searchInsert(arr, target3));  //5 - insertion
    }
}
