package Questions;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,-1,nums,dp);

    }

    private static int helper(int index, int prevIndex, int[] nums, int[][] dp) {
        if(index==nums.length) return 0;
        if(dp[index][prevIndex+1]!=-1){
            return dp[index][prevIndex+1];
        }
        int exclude = helper(index+1,prevIndex,nums,dp);
        int include = 0;
        if(prevIndex==-1||nums[index]>nums[prevIndex]){
            include = 1+helper(index+1,index,nums,dp);
        }
        dp[index][prevIndex+1]=Math.max(exclude,include);

        return dp[index][prevIndex+1];
    }

    static void main() {
        int []nums = new int[]{10,9,2,5,3,7,101,18}; //Output => 4
        System.out.println(lengthOfLIS(nums));
    }
}
