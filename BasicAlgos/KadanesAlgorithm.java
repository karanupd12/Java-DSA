package BasicAlgos;

/*
Kadane's Algorithm is a popular method used to find the maximum sum of a contiguous subarray within a 1-D array of numbers.
- It's efficient with a time complexity of 𝑂(𝑛) and constant 𝑂(1) space making it ideal for solving problems related to subarray sums.

Algorithm:
Kadane's Algorithm finds the maximum sum of a contiguous subarray:

- Initialize current_sum and max_sum with the first element.
- For each element, update current_sum = max(element, current_sum + element).
- Update max_sum = max(max_sum, current_sum) after each step.
- Return max_sum.
*/



public class KadanesAlgorithm {

    public static int maxSubArraySum(int[] arr){
        int currSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            currSum = Math.max(arr[i], currSum+arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, -2, 5, -1, 4};
        System.out.println(maxSubArraySum(arr));   //9
    }
}
