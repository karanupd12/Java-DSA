package LeetCodeQues;
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


import java.util.Arrays;

import static java.util.Arrays.*;

public class MergeSortedArr {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m, j = 0;
            while (i < m + n && j < n) {
                nums1[i] = nums2[j];
                i++;
                j++;
            }
            Arrays.sort(nums1);
        }
    }
}
