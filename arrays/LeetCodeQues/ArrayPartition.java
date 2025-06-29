package arrays.LeetCodeQues;
import java.util.Arrays;

public class ArrayPartition {

    public static int helper(int[] nums, int sum, int i){
        if (i >= nums.length)
            return sum;
        sum += nums[i];
        return helper(nums, sum, i += 2);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0, 0);

        //by iteration (no helper needed but takes more runtime)
//        int n = nums.length;
//        int sum = 0;
//        Arrays.sort(nums);
//        for(int i = 0; i < n; i += 2){
//            sum += nums[i];
//        }
//        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(arrayPairSum(arr));
    }
}
