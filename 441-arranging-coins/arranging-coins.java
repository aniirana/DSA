class Solution {
    public int arrangeCoins(int n) {
        return solve(n, 1);
    }

    int solve(int coins, int row) {
        if (coins < row)
            return row - 1;

        return solve(coins - row, row + 1);
    }
}