class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return solve(0, nums, dp);
    }

    public int solve(int i, int[] nums, Integer[] dp) {
        if (i >= nums.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int rob = nums[i] + solve(i + 2, nums, dp);
        int skip = solve(i + 1, nums, dp);

        return dp[i] = Math.max(rob, skip);
    }
}