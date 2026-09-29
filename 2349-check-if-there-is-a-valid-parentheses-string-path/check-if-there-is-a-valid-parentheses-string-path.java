class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int len = m + n - 1;

        // Valid parentheses string must have even length
        if (len % 2 != 0) {
            return false;
        }

        // Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][len + 1];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance <= len; balance++) {

                    boolean reachable = false;

                    // From top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        reachable = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        reachable = true;
                    }

                    if (!reachable) {
                        continue;
                    }

                    if (grid[i][j] == '(') {
                        if (balance + 1 <= len) {
                            dp[i][j][balance + 1] = true;
                        }
                    } else {
                        if (balance > 0) {
                            dp[i][j][balance - 1] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}