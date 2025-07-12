package DYNAMIC_Programming.OneDimDP;


/*
Contains both House Robber I and II problems.
Approach is similar for both problems, but the second one requires handling the circular nature of the houses.
// House Robber I: https://leetcode.com/problems/house-robber/
// House Robber II: https://leetcode.com/problems/house-robber-ii/

*/
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        //for circular, the last is adjacent to first
        int[] leaveFirst = new int[n];   //so run once by leaving first
        for(int i = 1; i < n; i++) leaveFirst[i] = nums[i];

        int[] leaveLast = new int[n];    //and once by leaving last
        for(int i = 0; i < n-1; i++) leaveLast[i] = nums[i];

        return Math.max(houseRobber(leaveFirst), houseRobber(leaveLast)); //return max in both
    }

    //this is simple max adjacent - house robber problem
    private int houseRobber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev1 = nums[0], prev2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int rob = prev1 + nums[i];
            int skip = prev2;
            int curr = Math.max(rob, skip);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}


/*House robber breakdown
Brute Force - try out all combo - recursion (simple pick and drop)
int rob(int[] nums, int i) {
    if(i >= nums.length) return 0;
    int rob = nums[i] + rob(nums, i+2);
    int skip = rob(nums, i+1);
    return Math.max(rob, skip);
}

Memoization - store results of subproblems (maintain memo array)
int rob(int[] nums, int i, int[] memo) {
    if(i >= nums.length) return 0;
    if(memo[i] != -1) return memo[i];
    int rob = nums[i] + rob(nums, i+2, memo);
    int skip = rob(nums, i+1, memo);
    return memo[i] = Math.max(rob, skip);;
}

Tabulation - bottom up approach (maintain dp array)
int rob(int[] nums) {
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for(int i = 2; i < nums.length; i++) {
        int rob = dp[i-2] + nums[i];
        int skip = dp[i-1];
        dp[i] = Math.max(rob, skip);
    }
    return dp[nums.length - 1];
}

Space Optimization - use two variables to store previous results (above we have used this approach)
*/