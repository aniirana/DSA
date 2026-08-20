class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    pal[i][j] = true;
                } else if (gap == 1) {
                    pal[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pal[i][j] = (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]);
                }
            }
        }
        int[] dp = new int[n+1];
        dp[n]=-1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (pal[i][j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}