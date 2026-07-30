class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        if (target > m) return -1;

        int INF = (int)1e9;

        int[][][] dp = new int[m + 1][target + 1][n + 1];

        // Initialize
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 1; i <= m; i++) {

            for (int t = 1; t <= target; t++) {

                for (int color = 1; color <= n; color++) {

                    // Already painted with another color
                    if (houses[i - 1] != 0 && houses[i - 1] != color)
                        continue;

                    int paintCost = 0;

                    if (houses[i - 1] == 0)
                        paintCost = cost[i - 1][color - 1];

                    for (int prevColor = 0; prevColor <= n; prevColor++) {

                        // Same color -> no new neighborhood
                        if (prevColor == color) {

                            if (dp[i - 1][t][prevColor] != INF) {

                                dp[i][t][color] = Math.min(
                                        dp[i][t][color],
                                        dp[i - 1][t][prevColor] + paintCost
                                );
                            }
                        }

                        // Different color -> new neighborhood
                        else {

                            if (t > 0 && dp[i - 1][t - 1][prevColor] != INF) {

                                dp[i][t][color] = Math.min(
                                        dp[i][t][color],
                                        dp[i - 1][t - 1][prevColor] + paintCost
                                );
                            }
                        }
                    }
                }
            }
        }

        int ans = INF;

        for (int color = 1; color <= n; color++) {
            ans = Math.min(ans, dp[m][target][color]);
        }

        return ans == INF ? -1 : ans;
    }
}