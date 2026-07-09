class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

        int currMax = 0;
        int ans = 0;

        for (int len = 1; len <= k && i + len - 1 < n; len++) {

        currMax = Math.max(currMax, arr[i + len - 1]);

        ans = Math.max(ans,
                       currMax * len + dp[i + len]);
        }

        dp[i] = ans;
    }

return dp[0];
    }
}