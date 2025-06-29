package search.leetcodeques;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchRange {
    public static ArrayList<Integer> searchRange(int[] nums, int target) {
        int a = fi(nums, target);
        int b = li(nums, target);
        ArrayList <Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        return list;
    }

    public static int fi(int[] nums, int target){
        int s = 0;
        int e = nums.length - 1;
        int index = -1;
        while (s <= e){
            int m = s+(e-s)/2;
            if (nums[m] == target){
                e = m - 1;
                index = m;
            }
            else if (target < nums[m])
                e = m - 1;
            else
                s = m + 1;
        }
        return index;
    }

    public static int li(int[] nums, int target){
        int s = 0;
        int e = nums.length - 1;
        int index = -1;
        while (s <= e){
            int m = s+(e-s)/2;
            if (nums[m] == target){
                s = m + 1;
                index = m;
            }
            else if (target < nums[m])
                e = m - 1;
            else
                s = m + 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] nums2 = {2,2};
        int target1 = 8;
        int target2 = 6;
        searchRange(nums, target1);
        System.out.println(searchRange(nums, target1));
        System.out.println(searchRange(nums, target2));
        System.out.println(searchRange(nums2, 2));
    }
}
