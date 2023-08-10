class Solution {
	// problem statement and judging: https://leetcode.com/problems/longest-increasing-subsequence
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        
        for(int i=0; i<len; ++i) { dp[i] = 1; }
        
        for(int i=0; i<len; ++i) {
            for(int j=0; j<i; ++j) {
                if( nums[j] < nums[i] ) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int max_dp = 1;
        for(int i=1; i<len; ++i) {
            max_dp = Math.max(dp[i], max_dp);
        }
        
        return max_dp;
    }
}