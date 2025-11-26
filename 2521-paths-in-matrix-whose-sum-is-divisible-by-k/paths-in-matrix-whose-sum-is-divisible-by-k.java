class Solution {
    int[][][] dp;
    int mod = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        // dp[row][col][k] -> storing states based on (i,j,sum%k)
        dp = new int[row][col][k];
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);

        return traversal(grid, 0, 0, 0, k);
    }

    public int traversal(int[][] grid, int i, int j, int sum, int k) {
        int row = grid.length;
        int col = grid[0].length;

        if (i >= row || j >= col) return 0;

        sum = (sum + grid[i][j]) % k; // Only store mod value

        if (i == row - 1 && j == col - 1) {
            return (sum % k == 0) ? 1 : 0;
        }

        if (dp[i][j][sum] != -1) return dp[i][j][sum];

        int right = traversal(grid, i, j + 1, sum, k);
        int down = traversal(grid, i + 1, j, sum, k);

        return dp[i][j][sum] = (right + down) % mod;
    }
}
