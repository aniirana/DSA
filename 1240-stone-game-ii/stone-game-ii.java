class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for(int M = 1; M <= n; M++) {
            dp[n][M] = 0;
        }

        int[] suffix = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        for(int i = n - 1; i >= 0; i--) {

            for(int M = 1; M <= n; M++) {

                for(int x = 1; x <= 2 * M && i + x <= n; x++) {

                    int newM = Math.max(M, x);

                    int taken = suffix[i] - suffix[i + x];

                    int current = taken - dp[i + x][newM];

                    dp[i][M] = Math.max(dp[i][M], current);
                }
            }
        }

        return (suffix[0] + dp[0][1]) / 2;
    }
}