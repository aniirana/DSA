import java.util.*;

class Solution {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;

        int[][][] dp = new int[n][n][n];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        int ans = solve(grid, dp, 0, 0, 0);

        return Math.max(0, ans);
    }

    public int solve(int[][] grid, int[][][] dp,
                     int r1, int c1, int r2) {

        int n = grid.length;

        // calculate c2
        int c2 = r1 + c1 - r2;

        // out of bounds
        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n || c2 < 0) {

            return -1000;
        }

        // thorn
        if (grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {

            return -1000;
        }

        // destination
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // memoized
        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        int cherries = grid[r1][c1];

        // different cells
        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        // both down
        int dd = solve(
            grid, dp,
            r1 + 1, c1,
            r2 + 1
        );

        // P1 down, P2 right
        int dr = solve(
            grid, dp,
            r1 + 1, c1,
            r2
        );

        // P1 right, P2 down
        int rd = solve(
            grid, dp,
            r1, c1 + 1,
            r2 + 1
        );

        // both right
        int rr = solve(
            grid, dp,
            r1, c1 + 1,
            r2
        );

        int best = Math.max(
            dd,
            Math.max(dr, Math.max(rd, rr))
        );

        return dp[r1][c1][r2] = cherries + best;
    }
}