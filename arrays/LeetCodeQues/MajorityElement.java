package arrays.LeetCodeQues;

import java.util.Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums.length/2;
    }
}
