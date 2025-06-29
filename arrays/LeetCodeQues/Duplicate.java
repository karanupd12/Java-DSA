//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
package arrays.LeetCodeQues;
import java.util.ArrayList;
public class Duplicate {
    public int removeDuplicates(int[] nums) {
        // we will return the total distinct elements in array
        int k = 0;
        ArrayList <Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            boolean dup = false;

            for (int j = 0; j < list.size(); j++){
                if (nums[i] == list.get(i)){
                    dup = true;
                    break;
                }
            }

            //making a list of distinct elements
            if (dup == false){
                list.add(nums[i]);
                k++;
            }
        }

        //updating the orignal array
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return k;
    }
}
