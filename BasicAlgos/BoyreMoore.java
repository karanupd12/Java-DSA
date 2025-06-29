package BasicAlgos;

//The Boyer-Moore Voting Algorithm is an efficient algorithm used to find the majority element in an array.
// The majority element is an element that appears more than n/2 times(or n/3), where n is the size of the array.
// This algorithm works in O(n) time complexity with O(1) space.


import java.util.ArrayList;
import java.util.List;

public class BoyreMoore {

    //For majority element with freq > n/2
    public static int majorityElement1(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num : nums){
            if(count == 0) candidate = num;
            if(num == candidate) count++;
            else count--;
        }
        return candidate;
    }


    //For majority element with freq > n/3 (intution : there can be atmost 2 majority elements only )
    public static List<Integer> majorityElement2(int[] nums) {
        int bm = Math.floorDiv(nums.length, 3);
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        // verification
        int cand1Freq = 0, cand2Freq = 0;
        for (int num : nums) {
            if (num == candidate1) cand1Freq++;
            else if (num == candidate2) cand2Freq++;
        }
        if (cand1Freq > bm) ans.add(candidate1);
        if (cand2Freq > bm) ans.add(candidate2);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2,  3, 3 , 3};
        System.out.println(majorityElement1(arr));     //2
        System.out.println(majorityElement2(arr));     //[3, 2]
    }

}
