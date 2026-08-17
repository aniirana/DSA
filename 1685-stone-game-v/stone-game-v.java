class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                for (int k = i; k < j; k++) {
                    int leftsum = prefix[k + 1] - prefix[i];
                    int rightsum = prefix[j + 1] - prefix[k + 1];

                    if (leftsum < rightsum) {
                        dp[i][j] = Math.max(leftsum + dp[i][k],dp[i][j]);
                    } else if (rightsum < leftsum) {
                        dp[i][j] = Math.max(rightsum+ dp[k + 1][j],dp[i][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], leftsum + Math.max(dp[i][k], dp[k + 1][j]));
                    }

                }
            }
        }
        return dp[0][n-1];
    }
}